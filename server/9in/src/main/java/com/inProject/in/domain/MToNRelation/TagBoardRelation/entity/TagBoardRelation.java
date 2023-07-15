package com.inProject.in.domain.MToNRelation.TagBoardRelation.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tagBoardRelation")
public class TagBoardRelation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    @ManyToOne
    @JoinColumn(name = "skillTag_id")
    private SkillTag skillTag;
}
