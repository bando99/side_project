package com.inProject.in.domain.Board.Dto;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.SkillTag.Dto.ResponseSkillTagDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseMultiBoardsDto {   //게시글 리스트를 리턴할 때 사용하는 dto.
    private Long board_id;
    private String username;
    private String type;
    private String title;
//    private String text;               //게시글 내용은 보여줄 필요 x
    private String proceed_method;
    private LocalDateTime period;
    private int comment_cnt;

//    private User author;
//    private List<ApplicantBoardRelation> applicantBoardRelationList;
//    private List<Comment> commentList;
//    private List<TagBoardRelation> tagBoardRelationList;
//    private List<ClipBoardRelation> clipBoardRelationList;
//    private List<RoleBoardRelation> roleBoardRelationList;

    public ResponseMultiBoardsDto(Board board){
        this.board_id = board.getId();
        this.username = board.getAuthor().getUsername();
        this.type = board.getType();
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
