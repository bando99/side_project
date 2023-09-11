package com.inProject.in.domain.Profile.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
}
