package com.inProject.in.domain.MToNRelation.TagBoardRelation.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResponseTagBoardRelationDto {
    private Long id;
    private Long board_id;
    private Long skilltag_id;
}
