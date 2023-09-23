package com.inProject.in.domain.Profile.Dto.response;

import com.inProject.in.domain.Profile.entity.MyInfo;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMyInfoDto {
    private String nickname;
    private String role;
    private String career;
    private String phone_num;
    private String school;
    private String major;
    private String graduated;

    public ResponseMyInfoDto(MyInfo myInfo){
        this.nickname = myInfo.getNickname();
        this.role = myInfo.getRole();
        this.career = myInfo.getCareer();
        this.phone_num = myInfo.getPhone_num();
        this.school = myInfo.getSchool();
        this.major = myInfo.getMajor();
        this.graduated = myInfo.getGraduated();
    }
}
