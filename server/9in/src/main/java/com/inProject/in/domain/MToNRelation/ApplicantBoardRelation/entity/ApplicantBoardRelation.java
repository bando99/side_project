package com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity;


import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "applicantBoardRelation")
public class ApplicantBoardRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User board_applicant;

}
