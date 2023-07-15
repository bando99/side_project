package com.inProject.in.domain.Board.Dto;

import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.entity.TagBoardRelation;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseBoardDto {
    private Long id;
    private String type;
    private String title;
    private String text;
    private String proceed_method;
    private LocalDateTime period;
    private int comment_cnt;
    private User author;
    private List<ApplicantBoardRelation> applicantBoardRelationList;
    private List<Comment> commentList;
    private List<TagBoardRelation> tagBoardRelationList;
    private List<ClipBoardRelation> clipBoardRelationList;
    private List<RoleBoardRelation> roleBoardRelationList;

    public ResponseBoardDto(Board board){
        this.id = board.getId();
        this.type = board.getType();
        this.text = board.getText();
        this.title = board.getTitle();
        this.proceed_method = board.getProceed_method();
        this.period = board.getPeriod();
        this.comment_cnt = board.getComment_cnt();
        this.author = board.getAuthor();
        this.applicantBoardRelationList = board.getApplicantBoardRelationList();
        this.commentList = board.getCommentList();
        this.tagBoardRelationList = board.getTagBoardRelationList();
        this.clipBoardRelationList = board.getClipBoardRelationList();
        this.roleBoardRelationList = board.getRoleBoardRelationList();
    }
}
