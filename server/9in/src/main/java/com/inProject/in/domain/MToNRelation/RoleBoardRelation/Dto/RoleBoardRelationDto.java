package com.inProject.in.domain.MToNRelation.RoleBoardRelation.Dto;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoleBoardRelationDto {
    private RoleNeeded roleNeeded;
    private Board board;
    private int pre_cnt;
    private int want_cnt;
}
