package com.inProject.in.domain.Board.Dto.request;


import com.inProject.in.domain.RoleNeeded.Dto.RequestUsingInBoardDto;
import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RequestUpdateBoardDto {
    private String title;
    private String text;
    private String type;
    private String proceed_method;
    private LocalDateTime period;
    private List<RequestSkillTagDto> requestSkillTagDtoList;
    private List<RequestUsingInBoardDto> requestUsingInBoardDtoList;

    /*
    String name;
    int pre_cnt;
    int want_cnt;
     */


}
