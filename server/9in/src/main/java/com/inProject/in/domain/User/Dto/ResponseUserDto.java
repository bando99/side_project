package com.inProject.in.domain.User.Dto;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseUserDto {

    private Long id;
    private String username;
    private String mail;
    private List<Board> authoredBoardList;
    private List<ApplicantBoardRelation> applicantBoardRelationList;
    private List<ApplicantRoleRelation> applicantRoleRelationList;
    private List<ClipBoardRelation> clipBoardRelationList;
    private List<Comment> commentList;

    public ResponseUserDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.mail = user.getMail();
        this.authoredBoardList = user.getAuthoredBoardList();
        this.applicantBoardRelationList = user.getApplicantBoardRelationList();
        this.applicantRoleRelationList = user.getApplicantRoleRelationList();
        this.clipBoardRelationList = user.getClipBoardRelationList();
        this.commentList = user.getCommentList();
    }
}
