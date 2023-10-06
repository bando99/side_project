package com.inProject.in.domain.MToNRelation.ClipBoardRelation.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestClipDto {
    private Long user_id;
    private Long board_id;
}
