package com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "clipBoardRelation")
public class ClipBoardRelation extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User clipUser;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board clipedBoard;
}
