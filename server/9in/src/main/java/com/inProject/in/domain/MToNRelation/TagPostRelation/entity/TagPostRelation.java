package com.inProject.in.domain.MToNRelation.TagPostRelation.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tagPostRelation")
public class TagPostRelation extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skillTag_id")
    private SkillTag skillTag;
}
