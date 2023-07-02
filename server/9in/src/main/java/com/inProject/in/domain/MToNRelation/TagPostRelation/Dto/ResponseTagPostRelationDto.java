package com.inProject.in.domain.MToNRelation.TagPostRelation.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResponseTagPostRelationDto {
    private Long id;
    private Long user_id;
    private Long skilltag_id;
}
