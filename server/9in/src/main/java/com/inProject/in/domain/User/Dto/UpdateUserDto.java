package com.inProject.in.domain.User.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UpdateUserDto {
    private String user_id;
    private String username;
    private String password;
    private String mail;

}
