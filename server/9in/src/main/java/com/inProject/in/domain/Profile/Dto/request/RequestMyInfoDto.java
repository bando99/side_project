package com.inProject.in.domain.Profile.Dto.request;

import com.inProject.in.domain.Profile.entity.MyInfo;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestMyInfoDto {
    private String nickname;
    private String role;
    private String career;
    private String phone_num;
    private String school;
    private String major;
    private String graduated;
    private Long user_id;
    public MyInfo toEntity(User user){
        return MyInfo.builder()
                .nickname(nickname)
                .role(role)
                .career(career)
                .phone_num(phone_num)
                .school(school)
                .major(major)
                .graduated(graduated)
                .user(user)
                .build();
    }
}
