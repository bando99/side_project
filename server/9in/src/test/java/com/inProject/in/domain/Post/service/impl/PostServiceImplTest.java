package com.inProject.in.domain.Post.service.impl;

import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import com.inProject.in.domain.MToNRelation.RolePostRelation.repository.RolePostRelationRepository;
import com.inProject.in.domain.MToNRelation.TagPostRelation.Dto.TagPostRelationDto;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
import com.inProject.in.domain.MToNRelation.TagPostRelation.repository.TagPostRelationRepository;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.Post.Dto.ResponsePostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.Post.service.PostService;
import com.inProject.in.domain.RoleNeeded.Dto.RoleNeededDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.RoleNeededRepository;
import com.inProject.in.domain.SkillTag.Dto.SkillTagDto;
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
import org.springframework.core.metrics.StartupStep;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.inProject.in.domain.SkillTag.entity.QSkillTag.skillTag;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
    @Mock
    RoleNeededRepository roleNeededRepository;
    @Mock
    RolePostRelationRepository rolePostRelationRepository;
    @InjectMocks
    PostService postService = new PostServiceImpl(
            postRepository,
            skillTagRepository,
            roleNeededRepository,
            tagPostRelationRepository,
            rolePostRelationRepository);

    @Test
    @DisplayName("게시글 하나 조회하기")
    void getPost() {

        //given
        Post post = Post.builder()
                .title("title1")
                .text("text1")
                .build();

        given(postRepository.save(post)).willReturn(post);
        given(postRepository.findById(1L)).willReturn(Optional.of(post));

        //when
        ResponsePostDto responsePostDto = postService.getPost(1L);

        //then
        assertEquals(post.getId(), responsePostDto.getId());
    }

    @Test
    @DisplayName("게시글 하나 생성")
    void createPost() {

        //given
        Long testId = 1l;

        PostDto postDto = PostDto.builder()
                .title("title1")
                .text("text1")
                .build();

        SkillTagDto skillTagDto = SkillTagDto.builder()
                .name("react")
                .build();

        RoleNeededDto roleNeededDto = RoleNeededDto.builder()
                .pre_cnt(0)
                .want_cnt(4)
                .name("백엔드")
                .build();

        Post post = postDto.toEntity();
        SkillTag skillTag = skillTagDto.toEntity();
        RoleNeeded roleNeeded = roleNeededDto.toEntity();

        post.setId(testId);
        skillTag.setId(testId);
        roleNeeded.setId(testId);

        TagPostRelation tagPostRelation = TagPostRelation.builder()
                .post(post)
                .skillTag(skillTag)
                .build();

        RolePostRelation rolePostRelation = RolePostRelation.builder()
                .roleNeeded(roleNeeded)
                .post(post)
                .build();

        List<SkillTagDto> skillTagDtoList = new ArrayList<>();
        List<RoleNeededDto> roleNeededDtoList = new ArrayList<>();

        skillTagDtoList.add(skillTagDto);
        roleNeededDtoList.add(roleNeededDto);

        given(postRepository.save(any(Post.class))).willReturn(post);
        given(skillTagRepository.findTagByName(any(String.class))).willReturn(Optional.of(skillTag));
        given(roleNeededRepository.findRoleByName(any(String.class))).willReturn(Optional.of(roleNeeded));
        given(tagPostRelationRepository.save(any(TagPostRelation.class))).willReturn(tagPostRelation);
        given(rolePostRelationRepository.save(any(RolePostRelation.class))).willReturn(rolePostRelation);


        //when
        ResponsePostDto responsePostDto = postService.createPost(postDto, skillTagDtoList, roleNeededDtoList);

        //then
        assertEquals(responsePostDto.getId(), post.getId());

    }

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