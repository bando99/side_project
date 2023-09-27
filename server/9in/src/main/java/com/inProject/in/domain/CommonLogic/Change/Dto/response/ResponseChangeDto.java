package com.inProject.in.domain.CommonLogic.Change.Dto.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseChangeDto {
    private String message;
    private boolean success;
}
