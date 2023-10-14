package com.inProject.in.domain.MToNRelation.ClipBoardRelation.Dto;

import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseClipBoardRelationDto {
    private String message;
    private boolean success;


}
