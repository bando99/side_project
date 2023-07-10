package com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.Dto;


import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.Dto.ResponseApplicantPostDto;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseApplicantRoleDto {
    private Long id;
    private User role_applicant;
    private RoleNeeded roleNeeded;

    public ResponseApplicantRoleDto(ApplicantRoleRelation applicantRoleRelation){
        this.id = applicantRoleRelation.getId();
        this.role_applicant = applicantRoleRelation.getRole_applicant();
        this.roleNeeded = applicantRoleRelation.getRoleNeeded();
    }
}
