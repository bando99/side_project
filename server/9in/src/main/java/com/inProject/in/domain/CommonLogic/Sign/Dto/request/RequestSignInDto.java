package com.inProject.in.domain.CommonLogic.Sign.Dto.request;

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
