package com.inProject.in.domain.SkillTag.Dto;

import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;

import java.util.ArrayList;
import java.util.List;

public class ResponseSkillTagDto {
    private String name;
    private List<TagPostRelation> tagPostRelationList = new ArrayList<>();
}
