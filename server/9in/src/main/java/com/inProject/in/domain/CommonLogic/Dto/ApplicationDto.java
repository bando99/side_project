package com.inProject.in.domain.CommonLogic.Dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApplicationDto {
    private Long board_id;
    private Long user_id;
    private Long role_id;
}
