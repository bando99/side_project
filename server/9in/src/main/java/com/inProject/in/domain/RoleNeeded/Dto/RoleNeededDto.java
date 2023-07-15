package com.inProject.in.domain.RoleNeeded.Dto;

import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RoleNeededDto {

    private String name;
    private int pre_cnt;
    private int want_cnt;
    private List<RoleBoardRelation> roleBoardRelationList;
    private List<ApplicantRoleRelation> applicantRoleRelationList;

    public RoleNeeded toEntity(){
        return RoleNeeded.builder()
                .name(name)
                .roleBoardRelationList(roleBoardRelationList)
                .applicantRoleRelationList(applicantRoleRelationList)
                .build();
    }
}
