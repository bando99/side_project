package com.inProject.in.domain.MToNRelation.ClipPostRelation.service.Impl;

import com.inProject.in.domain.MToNRelation.ClipPostRelation.Dto.ResponseClipPostRelationDto;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.repository.ClipPostRelationRepository;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.service.ClipPostRelationService;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.User.Dto.UserDto;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.hibernate.procedure.internal.PostgresCallableStatementSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ClipPostRelationServiceImpl implements ClipPostRelationService {

    private UserRepository userRepository;
    private PostRepository postRepository;
    private ClipPostRelationRepository clipPostRelationRepository;

    private final Logger log = LoggerFactory.getLogger(ClipPostRelationServiceImpl.class);

    @Autowired
    public ClipPostRelationServiceImpl( UserRepository userRepository,
                                        PostRepository postRepository,
                                        ClipPostRelationRepository clipPostRelationRepository){

        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.clipPostRelationRepository = clipPostRelationRepository;
    }


    @Override
    public ResponseClipPostRelationDto insertClip(Long user_id, Long post_id){


        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("clickClip에서 유효하지 않은 user id : " + user_id));

        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new IllegalArgumentException("clickClip에서 유효하지 않은 post id : " + post_id));

        log.info("Using insertClip in clip Service ==> post_id : " + post_id + " user_id : " + user_id);

        //유저가 누른 적 없는 게시물인지 확인.
        if(clipPostRelationRepository.isExistClipedPost(user, post) == false) {

            ClipPostRelation clipPostRelation = ClipPostRelation.builder()
                    .clipUser(user)
                    .clipedPost(post)
                    .build();

            ClipPostRelation createRelation = clipPostRelationRepository.save(clipPostRelation);
            ResponseClipPostRelationDto responseClipPostRelationDto = new ResponseClipPostRelationDto(createRelation);

            log.info("Insert Clip Post Relation ==> relation_id " + responseClipPostRelationDto.getId());

            return responseClipPostRelationDto;
        }

        return null;  //유저가 누른 적 있는 경우 null.
    }

    @Override
    public ResponseClipPostRelationDto deleteClip(Long user_id, Long post_id) {

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("clickClip에서 유효하지 않은 user id : " + user_id));

        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new IllegalArgumentException("clickClip에서 유효하지 않은 post id : " + post_id));

        ClipPostRelation clipPostRelation = clipPostRelationRepository.findClipedPost(user, post)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 등록이 되지 않은 게시글 : " + user_id + " " + post_id));

        log.info("Using deleteClip in clip service ==> post_id " + post_id + " user_id " + user_id);
        log.info("delete Clip Post Relation ==> relation_id " + clipPostRelation.getId());

        clipPostRelationRepository.delete(clipPostRelation);
        return null;
    }


}
