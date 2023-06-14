package com.inProject.in.domain.Post.repository.Impl;

import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.Skill.SkillTag.entity.SkillTag;
import com.inProject.in.domain.Skill.SkillTag.repository.SkilltagRepository;
import com.inProject.in.domain.Skill.TagRelation.entity.TagPostRelation;
import com.inProject.in.domain.Skill.TagRelation.repository.TagPostRelationRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomPostRepositoryImplTest {

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SkilltagRepository skilltagRepository;

    @Autowired
    TagPostRelationRepository tagPostRelationRepository;

    @BeforeEach
    void dataSetting(){

        String []tagsname = new String[]{"react", "java", "python"};
        List<User> userList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        List<SkillTag> skillTagList = new ArrayList<>();
        List<TagPostRelation> tagPostRelationList = new ArrayList<>();

        for(int i = 0 ; i < 3; i++){
            skillTagList.add(
                    SkillTag.builder()
                            .name(tagsname[i])
                            .build()
            );
        }

        for(int i = 0 ; i < 10 ; i++){
            userList.add(
                    User.builder()
                            .user_id("user" + i)
                            .mail("user" + i + "@naver.com")
                            .password(Integer.toString(i))
                            .build()
            );
        }

        for(int i = 1 ; i<= 50 ; i++){
            postList.add(
                    Post.builder()
                            .title("title" + i)
                            .text("text" + i)
                            .type((i % 2 == 0) ? "study" : "project")
                            .user(userList.get(i % 10))
                            .build()
            );
        }

        for(int i = 0; i < 50; i++){
            tagPostRelationList.add(
                    TagPostRelation.builder()
                            .post(postList.get(i))
                            .skillTag(skillTagList.get(i % 3))
                            .build()
            );
        }

        userRepository.saveAll(userList);
        postRepository.saveAll(postList);
        skilltagRepository.saveAll(skillTagList);
        tagPostRelationRepository.saveAll(tagPostRelationList);  //필수적으로 추가
    }

    @Test
    @DisplayName("모든 게시글 조건없이 출력")
    void findAllPost() {

        //given
        String title = "";
        String type = "";
        String user_id = "";
        List<String> tags = new ArrayList<>();


        //when
        Pageable pageable = PageRequest.of(0, 5);
        Page<Post> PostPage = postRepository.findPosts(pageable, user_id, title, type, tags);
        List<Post> PostList = PostPage.getContent();

        //then
        assertEquals(PostPage.getSize(), 5);
        assertEquals(PostList.size(), 5);

        for(Post post : PostList){
            System.out.println("--------------------------");
            System.out.println("Post content :" + post.getTitle() + ' ' +  post.getCreateAt());
            System.out.println("User id : " + post.getUser().getUser_id());
            System.out.println("--------------------------");
        }
    }

    @Test
    @DisplayName("작성자 이름 검색")
    void findUserPost(){

        //given
        String title = "";
        String type = "";
        String user_id = "user1";
        List<String> tags = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        //when
        long startmill = System.currentTimeMillis();
        Pageable pageable = PageRequest.of(0, 3);
        Page<Post> postPage =  postRepository.findPosts(pageable, user_id, title, type, tags);
        long endmill = System.currentTimeMillis();
        long querytime = endmill - startmill;

        //then
        assertEquals(postPage.getSize(), 3);
        List<Post> retPostList = postPage.getContent();
        assertEquals(retPostList.size(), 3);

        for(Post post : retPostList){
            System.out.println("-----------------");
            System.out.println("Post user id " + post.getUser().getUser_id());
            System.out.println("Post title " + post.getTitle());
            System.out.println("-----------------");
        }

        System.out.println("query time : " + querytime);
    }

    @Test
    @DisplayName("태그 1개인 게시글 필터링")
    void TagFiltering(){

        //given
        String title = "";
        String type = "";
        String user_id = "";
        List<String> tags = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        tags.add("react");

        //when
        long startmill = System.currentTimeMillis();
        Pageable pageable = PageRequest.of(0, 5);
        Page<Post> postPage = postRepository.findPosts(pageable, user_id, title, type, tags);
        long endmill = System.currentTimeMillis();
        long querytime = endmill - startmill;

        //then
        assertEquals(postPage.getSize(), 5);
        List<Post> retPostList = postPage.getContent();
        assertEquals(retPostList.size(), 5);

        for(Post post : retPostList){
            System.out.println("-----------------");
            System.out.println("Post user id " + post.getUser().getUser_id());
            System.out.println("Post title " + post.getTitle());
            System.out.print("Tag : ");

            post.getTagPostRelationList()
                    .stream().forEach(tag -> System.out.print(tag.getSkillTag().getName()));

            System.out.println();
            System.out.println("-----------------");
        }

        System.out.println("query time : " + querytime);

    }

}