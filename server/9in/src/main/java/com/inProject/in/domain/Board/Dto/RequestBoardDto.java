package com.inProject.in.domain.Board.Dto;

import com.inProject.in.domain.Board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestBoardDto {

    private String type;
    private String title;
    private String text;
    private String proceed_method;
    private LocalDateTime period;
    private int comment_cnt;
//    private User author;
//    private List<ApplicantBoardRelation> applicantBoardRelationList;
//    private List<Comment> commentList;
//    private List<TagBoardRelation> tagBoardRelationList;
//    private List<ClipBoardRelation> clipBoardRelationList;
//    private List<RoleBoardRelation> roleBoardRelationList;

    public Board toEntity(){
        return Board.builder()
                .type(type)
                .title(title)
                .text(text)
                .proceed_method(proceed_method)
                .period(period)
                .comment_cnt(comment_cnt)
//                .author(author)
//                .applicantBoardRelationList(applicantBoardRelationList)
//                .commentList(commentList)
//                .tagBoardRelationList(tagBoardRelationList)
//                .clipBoardRelationList(clipBoardRelationList)
//                .roleBoardRelationList(roleBoardRelationList)
                .build();
    }

    public RequestBoardDto(Board board){
        this.type = board.getType();
        this.text = board.getText();
        this.title = board.getTitle();
        this.proceed_method = board.getProceed_method();
        this.period = board.getPeriod();
        this.comment_cnt = board.getComment_cnt();
//        this.author = board.getAuthor();
//        this.applicantBoardRelationList = board.getApplicantBoardRelationList();
//        this.commentList = board.getCommentList();
//        this.tagBoardRelationList = board.getTagBoardRelationList();
//        this.clipBoardRelationList = board.getClipBoardRelationList();
//        this.roleBoardRelationList = board.getRoleBoardRelationList();
    }


}


