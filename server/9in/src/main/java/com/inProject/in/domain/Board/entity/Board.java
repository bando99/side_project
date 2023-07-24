package com.inProject.in.domain.Board.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.Board.Dto.BoardDto;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.entity.TagBoardRelation;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;



@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board") //테이블과 매핑
public class Board extends BaseEntity {

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private String proceed_method; //진행 방식
    @Column(nullable = false)
    private LocalDateTime period; //예상 기간
    @Column
    private int comment_cnt;  //댓글 개수

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;               //작성자 정보 접근

    @OneToMany(mappedBy = "board")
    @ToString.Exclude
    private List<ApplicantBoardRelation> applicantBoardRelationList;     //게시글에 지원서를 제출한 유저에 대한 정보

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comment> commentList;    //게시글에 작성된 댓글들

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TagBoardRelation> tagBoardRelationList;   //태그

    @OneToMany(mappedBy = "clipedBoard", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<ClipBoardRelation> clipBoardRelationList; //관심 클립으로 지정한 유저들

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<RoleBoardRelation> roleBoardRelationList;   //직군 관련 태그

    public void updateBoard(BoardDto boardDto){
        this.type = boardDto.getType();
        this.title = boardDto.getTitle();
        this.text = boardDto.getText();
        this.proceed_method = boardDto.getProceed_method();
        this.period = boardDto.getPeriod();
        this.tagBoardRelationList = boardDto.getTagBoardRelationList();
        this.roleBoardRelationList = boardDto.getRoleBoardRelationList();
    }
}
