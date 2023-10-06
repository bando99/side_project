package com.inProject.in.domain.Profile.Dto.response;

import com.inProject.in.domain.Profile.entity.Education;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResponseEducationDto {
    private String school; //대학교

    private String major;  //전공

    private Float grades; //학점
    private Float max_grades; //최대 학점

    private LocalDateTime admission; //입학일

    private LocalDateTime graduated; //졸업일
    private Long user_id;

    public ResponseEducationDto(Education education){
        this.school = education.getSchool();
        this.major = education.getMajor();
        this.grades = education.getGrades();
        this.max_grades = education.getMax_grades();
        this.admission = education.getAdmission();
        this.graduated = education.getGraduated();
        this.user_id = education.getUser().getId();
    }
}
