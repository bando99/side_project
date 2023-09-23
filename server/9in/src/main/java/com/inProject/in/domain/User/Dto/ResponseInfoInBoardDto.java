package com.inProject.in.domain.User.Dto;

import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseInfoInBoardDto {
    private String nickname;
    private String role;
    private String career;
    private String team_spot;  //팀 내 직위
    public ResponseInfoInBoardDto(ApplicantBoardRelation applicantBoardRelation){
        this.nickname = applicantBoardRelation.getBoard_applicant().getMyInfo().getNickname();
        this.role = applicantBoardRelation.getBoard_applicant().getMyInfo().getRole();
        this.career = applicantBoardRelation.getBoard_applicant().getMyInfo().getCareer();
    }
}
