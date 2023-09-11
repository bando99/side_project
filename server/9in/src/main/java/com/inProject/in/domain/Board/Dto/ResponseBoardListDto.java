package com.inProject.in.domain.Board.Dto;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.entity.TagBoardRelation;
import com.inProject.in.domain.RoleNeeded.Dto.ResponseRoleNeededDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseBoardListDto {   //게시글 리스트를 리턴할 때 사용하는 dto.
    private Long board_id;
    private String username;
    private String type;
    private String title;
//    private String text;               //게시글 내용은 보여줄 필요 x
    private String proceed_method;
    private LocalDateTime period;
    private int comment_cnt;
    private List<String> tags = new ArrayList<>();
    private List<ResponseRoleNeededDto> roles = new ArrayList<>();


    public ResponseBoardListDto(Board board){
        this.board_id = board.getId();
        this.username = board.getAuthor().getUsername();
        this.type = board.getType();
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

    }
}
