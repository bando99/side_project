package com.inProject.in.domain.Board.Dto;

import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestUsingInBoardDto;
import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestCreateBoardDto {   //게시글 생성 시 필요한 정보들.

//    private Long user_id;
    private String type;
    private String title;
    private String text;
    private String proceed_method;
    private LocalDateTime period;

    //직군
    private List<RequestUsingInBoardDto> roleNeededDtoList;

    //태그
    private List<RequestSkillTagDto> tagDtoList;

    public RequestBoardDto toBoardDto(){
        return RequestBoardDto.builder()
                .title(title)
                .text(text)
                .type(type)
                .period(period)
                .proceed_method(proceed_method)
                .build();
    }

}
