package com.inProject.in.domain.Comment.Dto;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {
    private User user;
    private Board board;
    private String text;
}
