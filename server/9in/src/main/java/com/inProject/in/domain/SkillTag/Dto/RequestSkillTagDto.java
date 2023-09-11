package com.inProject.in.domain.SkillTag.Dto;

import com.inProject.in.domain.SkillTag.entity.SkillTag;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestSkillTagDto {
    private String name;
    public SkillTag toEntity(){
        return SkillTag.builder()
                .name(name)
                .build();
    }
}
