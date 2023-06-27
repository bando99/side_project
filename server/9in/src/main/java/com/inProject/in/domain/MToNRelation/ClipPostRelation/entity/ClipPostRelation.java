package com.inProject.in.domain.MToNRelation.ClipPostRelation.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "clipPostRelation")
public class ClipPostRelation extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User clipUser;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post clipedPost;
}
