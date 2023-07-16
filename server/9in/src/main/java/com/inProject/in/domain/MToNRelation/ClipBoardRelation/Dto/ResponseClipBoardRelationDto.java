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
    private Long id;
    private User clipUser;
    private Board clipBoard;

    public ResponseClipBoardRelationDto(ClipBoardRelation clipBoardRelation){
        this.id = clipBoardRelation.getId();
        this.clipUser = clipBoardRelation.getClipUser();
        this.clipBoard = clipBoardRelation.getClipedBoard();
    }
}
