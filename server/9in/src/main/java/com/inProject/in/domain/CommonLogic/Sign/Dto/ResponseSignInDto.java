package com.inProject.in.domain.CommonLogic.Sign.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseSignInDto extends ResponseSignUpDto{
    private String token;
    private String refreshToken;

    @Builder
    public ResponseSignInDto(boolean success, int code, String msg, String token, String refreshToken){
        super(success, code, msg);
        this.token = token;
        this.refreshToken = refreshToken;
    }
}
