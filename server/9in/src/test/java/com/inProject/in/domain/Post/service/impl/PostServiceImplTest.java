package com.inProject.in.domain.Post.service.impl;

import com.inProject.in.domain.MToNRelation.TagPostRelation.Dto.TagPostRelationDto;
import com.inProject.in.domain.MToNRelation.TagPostRelation.repository.TagPostRelationRepository;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.Post.Dto.ResponsePostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.Post.service.PostService;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import com.inProject.in.domain.SkillTag.repository.SkillTagRepository;
import com.inProject.in.domain.User.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

/*

작성자 : 신윤성

postService의 단위테스트.
외부 요인인 repository를 배제하기 위해 mock객체 사용.

0625 : postService 생성자에 tagPostRelation 주입을 위한 파라미터 추가

 */

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {
    @Mock
    PostRepository postRepository;
    @Mock
    TagPostRelationRepository tagPostRelationRepository;
    @Mock
    SkillTagRepository skillTagRepository;
    @InjectMocks
    PostService postService = new PostServiceImpl(postRepository, tagPostRelationRepository, skillTagRepository);

    @Test
    @DisplayName("게시글 하나 조회하기")
    void getPost() {

        //given
        Post post = Post.builder()
                .title("title1")
                .text("text1")
                .build();

        given(postRepository.save(post)).willReturn(post);  //id 생성전략은 identity로 실제 db에 들어갈 때 생성됨. 그래서 h2같이 테스트용 db를 사용해야할 듯.
        given(postRepository.findById(1L)).willReturn(Optional.of(post));

        //when
        ResponsePostDto responsePostDto = postService.getPost(1L);

        //then
        assertEquals(post.getId(), responsePostDto.getId());
    }

//    @Test
//    void createPost() {
//        //given
//        PostDto postDto = PostDto.builder()
//                .id(1L)
//                .title("title1")
//                .text("text1")
//                .build();
//
//        TagPostRelationDto tagPostRelationDto = TagPostRelationDto.builder().build();
//
//
//        //when
//        ResponsePostDto responsePostDto = postService.createPost(postDto, tagPostRelationDto);
//
//        //then
//        assertEquals(responsePostDto.getId(), postDto.getId());
//
//    }

    @Test
    void updatePost() {
        //given

        //when
        //then
    }

    @Test
    void deletePost() {
    }

    @Test
    void getPostList() {
    }
}