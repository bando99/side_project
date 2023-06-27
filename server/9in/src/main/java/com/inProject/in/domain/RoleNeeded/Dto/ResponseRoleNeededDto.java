package com.inProject.in.domain.RoleNeeded.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseRoleNeededDto {
    private String name;
    private int pre_cnt;
    private int want_cnt;
    private long post_id;
}
