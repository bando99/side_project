package com.inProject.in.domain.Board.Dto;

import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.Dto.RoleBoardRelationDto;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.entity.TagBoardRelation;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.ResponseRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseBoardDto {
    private Long board_id;
    private String username;
    private String type;
    private String title;
    private String text;
    private String proceed_method;
    private LocalDateTime period;
    private int comment_cnt;
    private List<String> tags = new ArrayList<>();
    private List<ResponseRoleNeededDto> roles = new ArrayList<>();

    /*
    {
        role_id : long,
        name : string,
        pre_cnt : int,
        want_cnt : int
    }
     */

//    private User author;
//    private List<ApplicantBoardRelation> applicantBoardRelationList;
//    private List<Comment> commentList;
//    private List<TagBoardRelation> tagBoardRelationList;
//    private List<ClipBoardRelation> clipBoardRelationList;
//    private List<RoleBoardRelation> roleBoardRelationList;

    public ResponseBoardDto(Board board){
        this.board_id = board.getId();
        this.username = board.getAuthor().getUsername();
        this.type = board.getType();
        this.text = board.getText();
        this.title = board.getTitle();
        this.proceed_method = board.getProceed_method();
        this.period = board.getPeriod();
        this.comment_cnt = board.getComment_cnt();

        for(TagBoardRelation tagBoardRelation : board.getTagBoardRelationList()){
            this.tags.add(tagBoardRelation.getSkillTag().getName());
        }

        for(RoleBoardRelation roleBoardRelation : board.getRoleBoardRelationList()){
            ResponseRoleNeededDto responseRoleNeededDto = new ResponseRoleNeededDto(roleBoardRelation);
            this.roles.add(responseRoleNeededDto);
        }
//        this.author = board.getAuthor();
//        this.applicantBoardRelationList = board.getApplicantBoardRelationList();
//        this.commentList = board.getCommentList();
//        this.tagBoardRelationList = board.getTagBoardRelationList();
//        this.clipBoardRelationList = board.getClipBoardRelationList();
//        this.roleBoardRelationList = board.getRoleBoardRelationList();
    }
}
