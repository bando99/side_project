package com.inProject.in.domain.Post.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post") //테이블과 매핑
public class Post extends BaseEntity {

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

    @OneToMany(mappedBy = "post")
    @ToString.Exclude
    private List<ApplicantPostRelation> applicantPostRelationList;     //게시글에 지원서를 제출한 유저에 대한 정보

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comment> commentList;    //게시글에 작성된 댓글들

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TagPostRelation> tagPostRelationList;   //태그

    @OneToMany(mappedBy = "clipedPost", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<ClipPostRelation> clipPostRelationList; //관심 클립으로 지정한 유저들

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<RolePostRelation> rolePostRelationList;   //직군 관련 태그

    public void updatePost(PostDto postDto){
        this.type = postDto.getType();
        this.title = postDto.getTitle();
        this.text = postDto.getText();
        this.proceed_method = postDto.getProceed_method();
        this.period = postDto.getPeriod();
        this.tagPostRelationList = postDto.getTagPostRelationList();
        this.rolePostRelationList = postDto.getRolePostRelationList();
    }
}
