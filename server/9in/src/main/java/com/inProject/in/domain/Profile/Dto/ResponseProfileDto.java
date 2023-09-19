package com.inProject.in.domain.Profile.Dto;

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

    public ResponseProfileDto(ResponseCertificateDto responseCertificateDto,
                              ResponseProject_skillDto responseProjectSkillDto,
                              ResponseJob_exDto responseJobExDto,
                              ResponseEducationDto responseEducationDto){

        this.certificateDto = responseCertificateDto;
        this.educationDto = responseEducationDto;
        this.projectSkillDto = responseProjectSkillDto;
        this.jobExDto = responseJobExDto;
    }
}
