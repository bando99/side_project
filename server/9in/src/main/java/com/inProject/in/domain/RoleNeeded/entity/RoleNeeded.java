package com.inProject.in.domain.RoleNeeded.entity;


import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import com.inProject.in.domain.Post.entity.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private int pre_cnt;
    @Column
    private int want_cnt;
    @OneToMany(mappedBy = "roleNeeded", fetch = FetchType.EAGER)
    private List<RolePostRelation> rolePostRelationList = new ArrayList<>();               //여러 게시글과 연관

    @OneToMany(mappedBy = "roleNeeded", fetch = FetchType.EAGER)
    private List<ApplicantRoleRelation> applicantRoleRelationList = new ArrayList<>();   //여러 지원자들과 연관
}
