package com.inProject.in.domain.CommonLogic.Sign.Dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestSignUpDto {

//    @NotBlank(message = "아이디를 입력해주세요") //""," ",null 모두 허용하지 않음.
//    @Size(min=1, max=20, message="이름은 1자~20자로 입력해주세요.")
//    String userId;

    @NotBlank(message = "이름을 입력해주세요")
    String username;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8 - 20자의 비밀번호여야 합니다.")
    String password;

    @NotBlank
    String role;

    @NotBlank
    @Email(message = "이메일을 입력해주세요")
    String mail;
}
