package com.inProject.in.domain.User.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseUserDto {

    private Long id;
    private String user_id;
    private String mail;
}
