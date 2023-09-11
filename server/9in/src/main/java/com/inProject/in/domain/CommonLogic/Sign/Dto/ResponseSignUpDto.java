package com.inProject.in.domain.CommonLogic.Sign.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseSignUpDto {
    private boolean success;
    private int code;
    private String msg;
}
