package com.inProject.in.domain.User.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private String user_id;
    private String password;
    private String mail;

    public String getPassword() { //암호화 필요
        return password;
    }

    public void setPassword(String password) { //암호화 필요
        this.password = password;
    }
}


