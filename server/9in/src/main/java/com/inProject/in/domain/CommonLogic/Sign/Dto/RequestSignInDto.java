package com.inProject.in.domain.CommonLogic.Sign.Dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestSignInDto {
    String username;
    String password;

}
