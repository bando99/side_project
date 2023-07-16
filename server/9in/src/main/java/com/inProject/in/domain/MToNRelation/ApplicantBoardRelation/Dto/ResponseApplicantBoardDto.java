package com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.Dto;

import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseApplicantBoardDto {
    private Long id;
    private Board board;
    private User post_applicant;

    public ResponseApplicantBoardDto(ApplicantBoardRelation applicantBoardRelation){
        this.id = applicantBoardRelation.getId();
        this.board = applicantBoardRelation.getBoard();
        this.post_applicant = applicantBoardRelation.getBoard_applicant();
    }
}
