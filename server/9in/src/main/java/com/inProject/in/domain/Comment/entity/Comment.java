package com.inProject.in.domain.Comment.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Comment.Dto.CommentDto;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")       //N : 1
    private User user;
    @ManyToOne
    @JoinColumn(name = "board_id")       //N : 1
    private Board board;

    public void updateComment(CommentDto commentDto){
        this.text = commentDto.getText();
        this.user = commentDto.getUser();
        this.board = commentDto.getBoard();
    }
}
