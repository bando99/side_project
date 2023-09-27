package com.inProject.in.domain.CommonLogic.Sign.Dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestRefreshDto {
    private String refreshToken;
}
