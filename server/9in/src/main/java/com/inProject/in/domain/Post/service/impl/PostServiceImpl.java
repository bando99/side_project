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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private SkillTagRepository skilltagRepository;
    private RoleNeededRepository roleNeededRepository;
    private TagPostRelationRepository tagPostRelationRepository;
    private RolePostRelationRepository rolePostRelationRepository;

    private final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    public PostServiceImpl(PostRepository postRepository,
                           SkillTagRepository skilltagRepository,
                           RoleNeededRepository roleNeededRepository,
                           TagPostRelationRepository tagPostRelationRepository,
                           RolePostRelationRepository rolePostRelationRepository){

        this.postRepository = postRepository;
        this.tagPostRelationRepository = tagPostRelationRepository;
        this.skilltagRepository = skilltagRepository;
        this.rolePostRelationRepository = rolePostRelationRepository;
        this.roleNeededRepository = roleNeededRepository;

    }

    public List<TagPostRelation> InsertTagPostRelation(Post post, List<SkillTagDto> skillTagDtoList){

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

        return tagPostRelationList;
    }

    public List<RolePostRelation> InsertRolePostRelation(Post post, List<RoleNeededDto> roleNeededDtoList){

        List<RolePostRelation> rolePostRelationList = new ArrayList<>();

        for(RoleNeededDto roleNeededDto : roleNeededDtoList){

            RoleNeeded roleNeeded = roleNeededRepository.findRoleByName(roleNeededDto.getName())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 직군 정보" + roleNeededDto.toEntity().getId()));  //직군이 DB에 이미 정해진 대로 저장되어있다는 점.

            RolePostRelation rolePostRelation = RolePostRelation.builder()
                    .pre_cnt(roleNeededDto.getPre_cnt())
                    .want_cnt(roleNeededDto.getWant_cnt())                    //roleNeeded엔티티에는 pre, want카운트가 없음. 하지만 dto에는 있음. 입력하기 편하도록.
                    .roleNeeded(roleNeeded)
                    .post(post)
                    .build();

            rolePostRelationList.add(rolePostRelationRepository.save(rolePostRelation));
        }
        return rolePostRelationList;
    }


    @Override
    public ResponsePostDto getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("getpost에서 유효하지 않은 게시글 id " + id));

        ResponsePostDto responsePostDto = new ResponsePostDto(post);

        return responsePostDto;
    }

    @Override
    public ResponsePostDto createPost(PostDto postDto, List<SkillTagDto> skillTagDtoList, List<RoleNeededDto> roleNeededDtoList) {

        Post post = postDto.toEntity();
        post.setCreateAt(LocalDateTime.now());
        post.setUpdateAt(LocalDateTime.now());

        Post createPost = postRepository.save(post);

        List<TagPostRelation> tagPostRelationList = InsertTagPostRelation(createPost, skillTagDtoList);
        List<RolePostRelation> rolePostRelationList = InsertRolePostRelation(createPost, roleNeededDtoList);  //DB에 연관 데이터인 태그, 직군 데이터 삽입

        createPost.setTagPostRelationList(tagPostRelationList);
        createPost.setRolePostRelationList(rolePostRelationList);

        log.info("Using PostService createPost : " + createPost.getId() + " " + createPost.getTitle());

        for(TagPostRelation tagPostRelation : tagPostRelationList){
            log.info("Insert Tag - Post relation ==> post id : " + tagPostRelation.getPost().getId() + " tag id : "
                    + tagPostRelation.getSkillTag().getId());
        }

        for(RolePostRelation rolePostRelation : rolePostRelationList){
            log.info("Insert Role - Post relation ==> post id :" + rolePostRelation.getPost().getId()
                    + " role id : " + rolePostRelation.getRoleNeeded().getId());
        }

        ResponsePostDto responsePostDto = new ResponsePostDto(createPost);

        return responsePostDto;
    }

    @Override
    public ResponsePostDto updatePost(Long id, PostDto postDto) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("updatePost에서 유효하지 않은 게시글 id" + id));

        post.updatePost(postDto);
        Post updatedPost = postRepository.save(post);
        ResponsePostDto responsePostDto = new ResponsePostDto(updatedPost);

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

            ResponsePostDto responsePostDto = new ResponsePostDto(post);
            responsePostDtoList.add(responsePostDto);

        }

        return responsePostDtoList;
    }
}
