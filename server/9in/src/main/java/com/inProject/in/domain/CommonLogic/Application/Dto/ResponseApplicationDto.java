package com.inProject.in.domain.CommonLogic.Application.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ResponseApplicationDto {
    private Long applicant_id;
    private Long author_id;
    private Long board_id;
    private Long role_id;

}
