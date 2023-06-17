package com.inProject.in.domain.SkillTag.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
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
@Table(name = "skilltag")
public class SkillTag extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "skillTag", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<TagPostRelation> tagPostRelationList = new ArrayList<>();
}
