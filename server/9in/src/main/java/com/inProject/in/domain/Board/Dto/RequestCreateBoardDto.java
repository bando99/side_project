package com.inProject.in.domain.Board.Dto;

import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestUsingInBoardDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class RequestCreateBoardDto {


   // @NotBlank(message = "모집구분을 입력해 주세요.")

    private String type;



//    @NotBlank(message = "제목을 입력해 주세요.")
//    @Size(min = 1, max = 30, message = "최소 1글자 이상, 30글자 미만으로 입력하여 주세요")
    private String title;
//    @NotBlank(message = "내용을 입력해 주세요.")
//    @Size(min = 1, max = 500, message = "최소 1글자 이상, 500글자 미만으로 입력하여 주세요")
    private String text;
//    @NotBlank(message = "진행방식을 입력해 주세요.")
//    @Size(min = 1, max = 50 , message = "최소 1글자 이상, 50글자 미만으로 입력하여 주세요")
    private String proceed_method;
//    @NotBlank(message = "날짜설정을 입력해 주세요.")
//    @Future(message = "종료날짜는 미래의 시간으로 선택해야 합니다.") //미래의 시간으로 설정해야 된다.
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
