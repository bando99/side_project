package com.inProject.in.domain.MToNRelation.TagPostRelation.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
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
@Builder
@Table(name = "tagPostRelation")
public class TagPostRelation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "skilltag_id")
    private SkillTag skillTag;
}
