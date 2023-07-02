package com.inProject.in.domain.Post.service.impl;

import com.inProject.in.domain.MToNRelation.TagPostRelation.Dto.TagPostRelationDto;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
import com.inProject.in.domain.MToNRelation.TagPostRelation.repository.TagPostRelationRepository;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.Post.Dto.ResponsePostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.Post.service.PostService;
import com.inProject.in.domain.SkillTag.Dto.SkillTagDto;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import com.inProject.in.domain.SkillTag.repository.SkillTagRepository;
import com.inProject.in.domain.User.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private TagPostRelationRepository tagPostRelationRepository;
    private SkillTagRepository skilltagRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, TagPostRelationRepository tagPostRelationRepository,
                           SkillTagRepository skilltagRepository){

        this.postRepository = postRepository;
        this.tagPostRelationRepository = tagPostRelationRepository;
        this.skilltagRepository = skilltagRepository;

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
    public ResponsePostDto createPost(PostDto postDto, List<SkillTagDto> skillTagDtoList) {

        Post post = postDto.toEntity();
        List<TagPostRelation> tagPostRelationList = new ArrayList<>();

        for(SkillTagDto skillTagDto : skillTagDtoList){   //받아온 태그 당 관계 데이터를 생성

            SkillTag skillTag = skilltagRepository.findTagByName(skillTagDto.toEntity().getName())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 태그 정보 : " + skillTagDto.toEntity().getId()));    //태그 잘못 입력했으면 오류 반환

            TagPostRelation tagPostRelation = TagPostRelation.builder()
                    .skillTag(skillTag)
                    .post(post)
                    .build();

            tagPostRelationList.add(tagPostRelationRepository.save(tagPostRelation));
        }

        post.setTagPostRelationList(tagPostRelationList);
        Post createPost = postRepository.save(post);

        ResponsePostDto responsePostDto = ResponsePostDto.builder()
                .id(createPost.getId())
                .username(createPost.getUsername())
                .type(createPost.getType())
                .title(createPost.getTitle())
                .text(createPost.getText())
                .tagPostRelationList(createPost.getTagPostRelationList())
                .build();

        return responsePostDto;
    }

    @Override
    public ResponsePostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).get();
        post.setType(postDto.getType());
        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());
        post.setTagPostRelationList(postDto.getTagPostRelationList());

        Post updatedPost = postRepository.save(post);

        ResponsePostDto responsePostDto = ResponsePostDto.builder()
                .id(updatedPost.getId())
                .username(updatedPost.getUsername())
                .type(updatedPost.getType())
                .title(updatedPost.getTitle())
                .text(updatedPost.getText())
                .tagPostRelationList(updatedPost.getTagPostRelationList())
                .build();

        return responsePostDto;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }


    @Override
    public List<ResponsePostDto> getPostList(Pageable pageable, String user_id, String title, String type, List<String> tags, User User) {

        Page<Post> postPage = postRepository.findPosts(pageable, user_id, title, type, tags);
        List<Post> postList = postPage.getContent();
        List<ResponsePostDto> responsePostDtoList = new ArrayList<>();

        for (Post post : postList) {
            ResponsePostDto responsePostDto = ResponsePostDto.builder()
                    .id(post.getId())
                    .username(post.getAuthor().getUser_id())
                    .title(post.getTitle())
                    .text(post.getText())
                    .type(post.getType())
                    .comment_cnt(0)
                    .build();

            responsePostDtoList.add(responsePostDto);
        }

        return responsePostDtoList;
    }



}
