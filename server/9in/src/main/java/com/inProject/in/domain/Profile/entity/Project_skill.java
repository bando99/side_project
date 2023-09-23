package com.inProject.in.domain.Profile.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Profile.Dto.request.RequestProject_skillDto;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicUpdate
@Table(name = "project_skill")
public class Project_skill extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String project_name;
    @Column
    private LocalDateTime start_date;
    @Column
    private LocalDateTime end_date;
    @Column
    private String brief_text;
    @Column
    private String github_link;
    @Column
    private String skill_in_project;
    @Column
    private String performance;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void updateProjectSkill(RequestProject_skillDto requestProjectSkillDto){
        this.project_name = requestProjectSkillDto.getProject_name();
        this.start_date = requestProjectSkillDto.getStart_date();
        this.end_date = requestProjectSkillDto.getEnd_date();
        this.brief_text = requestProjectSkillDto.getBrief_text();
        this.github_link = requestProjectSkillDto.getGithub_link();
        this.skill_in_project = requestProjectSkillDto.getSkill_in_project();
        this.performance = requestProjectSkillDto.getPerformance();
    }
}
