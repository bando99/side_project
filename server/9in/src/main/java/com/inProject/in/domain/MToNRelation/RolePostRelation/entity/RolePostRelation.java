package com.inProject.in.domain.MToNRelation.RolePostRelation.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "rolePostRelation")
public class RolePostRelation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleNeeded roleNeeded;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @Column
    private int pre_cnt;

    @Column
    private int want_cnt;

}
