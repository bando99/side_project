package com.inProject.in.domain.Post.repository.Impl;

import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomPostRepositoryImplTest {

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void findAllPost() {

        for(int i = 0 ; i < 10 ; i++){
            Post post = Post.builder()
                    .type((i%2 == 0) ? "project" : "study")
                    .title("title" + i)
                    .text("text" + i)
                    .build();
            postRepository.save(post);
        }

        Pageable pageable = PageRequest.of(0, 5, Sort.by("createAt").descending());
        Page<Post> PostPage = postRepository.findAllPost(pageable);

        assertEquals(PostPage.getSize(), 5);
        List<Post> PostList = PostPage.getContent();

        for(Post content : PostList){
            System.out.println("-----------------");
            System.out.println("Post content : " + content.getTitle() +  ' ' + content.getCreateAt());
            System.out.println("-----------------");
        }
    }

    @Test
    void findUserPost(){

        User user1 = User.builder()
                .user_id("user1")
                .password("1234")
                .mail("aa@naver.com")
                .build();

        User user2 = User.builder()
                .user_id("user2")
                .password("1234")
                .mail("bb@naver.com")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);

        List<Post> postList = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++){
            Post post = Post.builder()
                    .title("title" + i)
                    .text("text" + i)
                    .type((i % 2 == 0) ? "study" : "project")
                    .user((i % 2 == 0) ? user1 : user2)
                    .build();

            postList.add(post);
        }

        postRepository.saveAll(postList);

        Pageable pageable = PageRequest.of(0, 3, Sort.by("createAt").descending());
        Page<Post> postPage =  postRepository.findUserPost("user1", pageable);
        assertEquals(postPage.getSize(), 3);

        List<Post> retPostList = postPage.getContent();

        for(Post post : retPostList){
            System.out.println("-----------------");
            System.out.println("Post user id " + post.getUser().getUser_id());
            System.out.println("Post title " + post.getTitle());
            System.out.println("-----------------");
        }
    }
}