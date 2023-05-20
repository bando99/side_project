package com.inProject.in.domain.Post.service.impl;

import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.Post.Dto.ResponsePostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.Post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public ResponsePostDto getPost(Long id) {
        Post post = postRepository.findById(id).get();

        ResponsePostDto responsePostDto = ResponsePostDto.builder()
                .id(post.getId())
                .type(post.getType())
                .title(post.getTitle())
                .text(post.getText())
                .build();

        return responsePostDto;
    }

    @Override
    public ResponsePostDto createPost(PostDto postDto) {
        Post post = Post.builder()
                .type(postDto.getType())
                .title(postDto.getTitle())
                .text(postDto.getText())
                .build();
        Post createPost = postRepository.save(post);

        ResponsePostDto responsePostDto = ResponsePostDto.builder()
                .id(createPost.getId())
                .type(createPost.getType())
                .title(createPost.getTitle())
                .text(createPost.getText())
                .build();

        return responsePostDto;
    }

    @Override
    public ResponsePostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).get();
        post.setType(postDto.getType());
        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());

        Post updatedPost = postRepository.save(post);

        ResponsePostDto responsePostDto = ResponsePostDto.builder()
                .id(updatedPost.getId())
                .type(updatedPost.getType())
                .title(updatedPost.getTitle())
                .text(updatedPost.getText())
                .build();

        return responsePostDto;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
