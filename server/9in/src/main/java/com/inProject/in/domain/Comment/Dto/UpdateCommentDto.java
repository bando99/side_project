package com.inProject.in.domain.Comment.Dto;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateCommentDto {
//    private Long user_id;
//    private Long board_id;
    private String text;

}
