package com.inProject.in.domain.Post.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column
    private int comment_cnt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;                 //N : 1

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @ToString.Exclude                                         //이게 없으면 Tostring 순환참조 발생.
    private List<Comment> commentList = new ArrayList<>();    //다대일 양방향 매핑을 위한 부분.
}
