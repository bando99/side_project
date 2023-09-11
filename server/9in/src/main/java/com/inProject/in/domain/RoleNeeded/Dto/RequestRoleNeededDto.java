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
public class RequestRoleNeededDto {

    private List<String> name;   //직군들을 미리 생성할 때 한 번에 여러개도 생성할 수 있도록 list로 작성

//    private List<RoleBoardRelation> roleBoardRelationList;
//    private List<ApplicantRoleRelation> applicantRoleRelationList;

//    public RoleNeeded toEntity(){
//        return RoleNeeded.builder()
//                .name(name)
//                .build();
//    }
}
