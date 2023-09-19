package com.inProject.in.domain.CommonLogic.Sign.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseSignInDto extends ResponseSignUpDto{
    private String token;
    private String refreshToken;
    private Long user_id;
    private String username;

    @Builder
    public ResponseSignInDto(boolean success, int code, String msg, String token, String refreshToken, Long user_id, String username){
        super(success, code, msg);
        this.token = token;
        this.refreshToken = refreshToken;
        this.user_id = user_id;
        this.username = username;
    }
}
