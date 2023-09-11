package com.inProject.in.domain.Profile.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "job_ex")
public class Job_ex extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String company_name;
    @Column
    private LocalDateTime join_date;  //입사일
    @Column
    private LocalDateTime leave_date; //퇴사일
    @Column
    private String job_explanation; //직무 설명
    @Column
    private String skill_in_job; //직무 경험 시 경험한 기술 스택
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
