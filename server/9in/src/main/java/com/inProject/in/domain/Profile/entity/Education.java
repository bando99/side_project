package com.inProject.in.domain.Profile.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "education")
public class Education extends BaseEntity {
    @Column
    private String school; //대학교
    @Column
    private String major;  //전공
    @Column
    private Float grades; //학점
    @Column
    private Float max_grades; //최대 학점
    @Column
    private LocalDateTime admission; //입학일
    @Column
    private LocalDateTime graduated; //졸업일
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
