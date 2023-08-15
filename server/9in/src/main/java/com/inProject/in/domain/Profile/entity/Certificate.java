package com.inProject.in.domain.Profile.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "certificate")
public class Certificate extends BaseEntity {
    @Column
    private String certificate_name;  //자격증 이름
    @Column
    private String acquisition_date; //딴 날짜
    @Column
    private String link;
    @Column
    private String explanation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
