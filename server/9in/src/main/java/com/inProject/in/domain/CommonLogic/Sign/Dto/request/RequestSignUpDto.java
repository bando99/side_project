package com.inProject.in.domain.CommonLogic.Sign.Dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestSignUpDto {
    String username;
    String password;
    String role;
    String mail;
}
