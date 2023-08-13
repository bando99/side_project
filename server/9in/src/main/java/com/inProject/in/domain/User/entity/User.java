package com.inProject.in.domain.User.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.User.Dto.UpdateUserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "user") //테이블과 매핑
public class User extends BaseEntity {

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String mail;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Board> authoredBoardList;   //작성한 글들

    @OneToMany(mappedBy = "board_applicant", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ApplicantBoardRelation> applicantBoardRelationList; //지원한 게시글들

    @OneToMany(mappedBy = "role_applicant", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ApplicantRoleRelation> applicantRoleRelationList;  //지원한 역할

    @OneToMany(mappedBy = "clipUser")
    @ToString.Exclude
    private List<ClipBoardRelation> clipBoardRelationList; //관심 클립으로 지정한 게시글들

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comment> commentList = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updateUser(UpdateUserDto updateUserDto){
        this.username = updateUserDto.getUsername();
        this.password = updateUserDto.getPassword();
        this.mail = updateUserDto.getMail();
//        this.authoredBoardList = userDto.getAuthoredBoardList();
//        this.applicantBoardRelationList = userDto.getApplicantBoardRelationList();
//        this.applicantRoleRelationList = userDto.getApplicantRoleRelationList();
//        this.clipBoardRelationList = userDto.getClipBoardRelationList();
//        this.commentList = userDto.getCommentList();
    }

}
