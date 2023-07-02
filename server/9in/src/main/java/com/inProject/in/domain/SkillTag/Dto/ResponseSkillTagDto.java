package com.inProject.in.domain.SkillTag.Dto;

import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseSkillTagDto {
    private String name;
    private List<TagPostRelation> tagPostRelationList = new ArrayList<>();
}
