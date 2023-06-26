package com.inProject.in.domain.Post.service;

import com.inProject.in.domain.MToNRelation.TagPostRelation.Dto.TagPostRelationDto;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.Post.Dto.ResponsePostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.SkillTag.Dto.SkillTagDto;
import com.inProject.in.domain.User.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    ResponsePostDto getPost(Long id);

    ResponsePostDto createPost(PostDto postDto, List<SkillTagDto> skillTagDtoList);

    ResponsePostDto updatePost(Long id, PostDto postDto);

    void deletePost(Long id);

    List<ResponsePostDto> getPostList(Pageable pageable, String user_id, String title, String type, List<String> tags, User user);

}
