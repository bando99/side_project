package com.inProject.in.domain.CommonLogic.Mail.Dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendMailDto {
    private String address;   //메일 보내고자 하는 주소
    private String subject;  //메일 제목
    private String text;  //메일 내용

}
