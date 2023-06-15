package com.inProject.in.domain.Comment.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")       //N : 1
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")       //N : 1
    private Post post;
}
