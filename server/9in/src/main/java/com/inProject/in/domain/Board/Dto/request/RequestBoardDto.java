package com.inProject.in.domain.Board.Dto.request;

import com.inProject.in.domain.Board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestBoardDto {

    private String type;
    private String title;
    private String text;
    private String proceed_method;
    private LocalDateTime period;
    private int comment_cnt;

    public Board toEntity(){
        return Board.builder()
                .type(type)
                .title(title)
                .text(text)
                .proceed_method(proceed_method)
                .period(period)
                .comment_cnt(comment_cnt)
                .build();
    }

    public RequestBoardDto(Board board){
        this.type = board.getType();
        this.text = board.getText();
        this.title = board.getTitle();
        this.proceed_method = board.getProceed_method();
        this.period = board.getPeriod();
        this.comment_cnt = board.getComment_cnt();

    }


}


