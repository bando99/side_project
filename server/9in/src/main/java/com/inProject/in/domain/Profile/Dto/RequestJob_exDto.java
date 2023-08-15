package com.inProject.in.domain.Profile.Dto;

import com.inProject.in.domain.Profile.entity.Job_ex;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RequestJob_exDto {

    private String company_name;

    private LocalDateTime join_date;  //입사일

    private LocalDateTime leave_date; //퇴사일

    private String job_explanation; //직무 설명

    private String skill_in_job; //직무 경험 시 경험한 기술 스택
    private Long user_id;

    public Job_ex toEntity(User user){
        return Job_ex.builder()
                .company_name(company_name)
                .join_date(join_date)
                .leave_date(leave_date)
                .job_explanation(job_explanation)
                .skill_in_job(skill_in_job)
                .user(user)
                .build();
    }
}
