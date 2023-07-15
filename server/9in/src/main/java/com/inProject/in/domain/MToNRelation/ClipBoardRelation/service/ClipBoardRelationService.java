package com.inProject.in.domain.MToNRelation.ClipBoardRelation.service;

import com.inProject.in.domain.MToNRelation.ClipBoardRelation.Dto.ResponseClipBoardRelationDto;

public interface ClipBoardRelationService {
    ResponseClipBoardRelationDto insertClip(Long user_id, Long post_id);
    ResponseClipBoardRelationDto deleteClip(Long user_id, Long post_id);
}
