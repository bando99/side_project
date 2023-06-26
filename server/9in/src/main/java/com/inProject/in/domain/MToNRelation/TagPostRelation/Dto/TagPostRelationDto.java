package com.inProject.in.domain.MToNRelation.TagPostRelation.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TagPostRelationDto {
    private Long post_id;
    private Long skilltag_id;
}
