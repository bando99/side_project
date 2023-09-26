package com.inProject.in.domain.CommonLogic.Sign.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestSignInDto {
    @NotBlank
    String username;
    @NotBlank
    String password;

}
