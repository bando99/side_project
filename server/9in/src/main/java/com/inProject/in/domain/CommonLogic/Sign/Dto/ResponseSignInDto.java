package com.inProject.in.domain.CommonLogic.Sign.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseSignInDto extends ResponseSignUpDto{
    private String token;

    @Builder
    public ResponseSignInDto(boolean success, int code, String msg, String token){
        super(success, code, msg);
        this.token = token;
    }
}
