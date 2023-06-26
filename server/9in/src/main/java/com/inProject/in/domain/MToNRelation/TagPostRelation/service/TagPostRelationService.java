package com.inProject.in.domain.MToNRelation.TagPostRelation.service;

import com.inProject.in.domain.MToNRelation.TagPostRelation.Dto.ResponseTagPostRelationDto;

public interface TagPostRelationService {
    ResponseTagPostRelationDto getTagPostRelation();
    ResponseTagPostRelationDto createTagPostRelation();
    ResponseTagPostRelationDto updateTagPostRelation();
    ResponseTagPostRelationDto deleteTagPostRelation();
}
