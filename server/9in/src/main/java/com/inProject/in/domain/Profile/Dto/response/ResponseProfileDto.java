package com.inProject.in.domain.Profile.Dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResponseProfileDto {
    private ResponseCertificateDto certificateDto;
    private ResponseProject_skillDto projectSkillDto;
    private ResponseEducationDto educationDto;
    private ResponseJob_exDto jobExDto;
    private ResponseMyInfoDto myInfoDto;
    private Long clipedCounts;
    private Long projectCounts;
    private Long studyCounts;

//    public ResponseProfileDto(ResponseCertificateDto responseCertificateDto,
//                              ResponseProject_skillDto responseProjectSkillDto,
//                              ResponseJob_exDto responseJobExDto,
//                              ResponseEducationDto responseEducationDto,
//                              ResponseMyInfoDto responseMyInfoDto,
//                              ){
//
//        this.certificateDto = responseCertificateDto;
//        this.educationDto = responseEducationDto;
//        this.projectSkillDto = responseProjectSkillDto;
//        this.jobExDto = responseJobExDto;
//        this.myInfoDto = responseMyInfoDto;
//
//    }
}
