package com.inProject.in.domain.MToNRelation.ClipPostRelation.service;

import com.inProject.in.domain.MToNRelation.ClipPostRelation.Dto.ResponseClipPostRelationDto;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.User.Dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClipPostRelationService {
    ResponseClipPostRelationDto insertClip(Long user_id, Long post_id);
    ResponseClipPostRelationDto deleteClip(Long user_id, Long post_id);
}
