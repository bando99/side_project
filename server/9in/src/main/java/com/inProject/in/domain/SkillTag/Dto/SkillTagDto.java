package com.inProject.in.domain.SkillTag.Dto;

import com.inProject.in.domain.MToNRelation.TagBoardRelation.entity.TagBoardRelation;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SkillTagDto {
    private String name;
    private List<TagBoardRelation> tagBoardRelationList = new ArrayList<>();
    public SkillTag toEntity(){
        return SkillTag.builder()
                .name(name)
                .tagBoardRelationList(tagBoardRelationList)
                .build();
    }
}
