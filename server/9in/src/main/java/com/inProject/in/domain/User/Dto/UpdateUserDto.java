package com.inProject.in.domain.User.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UpdateUserDto {    //업데이트 할 때 서버로 전송할 DTO
    @NonNull
    private String username;
    private String password;
    private String mail;
}
