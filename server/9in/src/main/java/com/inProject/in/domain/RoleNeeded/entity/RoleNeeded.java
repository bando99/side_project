package com.inProject.in.domain.RoleNeeded.entity;


import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Post.entity.Post;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "roleNeeded")
public class RoleNeeded extends BaseEntity {
    @Column
    private String name;
    @Column
    private int pre_count;
    @Column
    private int want_count;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
