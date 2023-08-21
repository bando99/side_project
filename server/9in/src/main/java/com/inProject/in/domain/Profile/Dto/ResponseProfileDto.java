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
}
