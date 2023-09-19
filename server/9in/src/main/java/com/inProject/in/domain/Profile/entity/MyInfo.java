package com.inProject.in.domain.Profile.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname; //닉네임
    private String role;    //역할
    private String career;   //경력
    private String phone_num;  //연락처
    private String school; //학교
    private String major;  //전공
    private String graduated;  //졸업여부

    //기술 태그는 다대다관계를 설계해야 할 것 같음
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
