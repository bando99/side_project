package com.inProject.in.domain.User.Dto;


import jakarta.validation.constraints.*;
import lombok.*;

//유효성 검사 수행을 위해서는 controller에서 사용할 때 requestbody에 추가로 @Validated 어노테이션 지정 필요.
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    @NotBlank(message = "아이디를 입력해주세요")
    private String user_id;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8 - 20자의 비밀번호여야 합니다.")
    private String password;

    @Email(message = "이메일을 입력해주세요")
    private String mail;     //@문자 있는지 확인. 추가로 도메인 검사 또는 비정상적 메일인 지 확인하는 과정 필요.

    public String getPassword() { //암호화 필요
        return password;
    }

    public void setPassword(String password) { //암호화 필요
        this.password = password;
    }
}


