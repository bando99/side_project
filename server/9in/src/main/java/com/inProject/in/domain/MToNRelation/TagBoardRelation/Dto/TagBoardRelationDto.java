package com.inProject.in.domain.MToNRelation.TagBoardRelation.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TagBoardRelationDto {
    private Long board_id;
    private Long skilltag_id;
}
