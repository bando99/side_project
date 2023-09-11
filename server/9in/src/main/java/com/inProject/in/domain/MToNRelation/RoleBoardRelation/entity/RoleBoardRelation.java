package com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.Dto.RoleBoardRelationDto;
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
@Table(name = "roleBoardRelation")
public class RoleBoardRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleNeeded roleNeeded;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    @Column
    private int pre_cnt;
    @Column
    private int want_cnt;

    public void updateRolePostRelation(RoleBoardRelationDto roleBoardRelationDto){
        this.roleNeeded = roleBoardRelationDto.getRoleNeeded();
        this.board = roleBoardRelationDto.getBoard();
        this.pre_cnt = roleBoardRelationDto.getPre_cnt();
        this.want_cnt = roleBoardRelationDto.getWant_cnt();
    }

}
