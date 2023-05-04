package com.inProject.in.domain.User.Dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String user_id;
    private String mail;
    private int post_cnt;
}


