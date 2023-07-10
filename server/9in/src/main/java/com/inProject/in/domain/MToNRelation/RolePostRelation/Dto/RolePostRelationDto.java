package com.inProject.in.domain.MToNRelation.RolePostRelation.Dto;

import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RolePostRelationDto {
    private RoleNeeded roleNeeded;
    private Post post;
    private int pre_cnt;
    private int want_cnt;
}
