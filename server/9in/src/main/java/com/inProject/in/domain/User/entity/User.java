package com.inProject.in.domain.User.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.entity.Post;
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
    private String user_id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String mail;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Post> authoredPostList = new ArrayList<>();   //작성한 글들

    @OneToMany(mappedBy = "post_applicant", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ApplicantPostRelation> applicantPostRelationList = new ArrayList<>(); //지원한 게시글들

    @OneToMany(mappedBy = "role_applicant", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ApplicantRoleRelation> applicantRoleRelationList = new ArrayList<>();  //지원한 역할

    @OneToMany(mappedBy = "clipUser")
    @ToString.Exclude
    private List<ClipPostRelation> clipPostRelationList = new ArrayList<>(); //관심 클립으로 지정한 게시글들

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comment> commentList = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
