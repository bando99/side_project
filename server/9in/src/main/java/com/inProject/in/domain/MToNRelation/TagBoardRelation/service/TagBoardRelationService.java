package com.inProject.in.domain.MToNRelation.TagBoardRelation.service;

import com.inProject.in.domain.MToNRelation.TagBoardRelation.Dto.ResponseTagBoardRelationDto;

public interface TagBoardRelationService {
    ResponseTagBoardRelationDto getTagPostRelation();
    ResponseTagBoardRelationDto createTagPostRelation();
    ResponseTagBoardRelationDto updateTagPostRelation();
    ResponseTagBoardRelationDto deleteTagPostRelation();
}
