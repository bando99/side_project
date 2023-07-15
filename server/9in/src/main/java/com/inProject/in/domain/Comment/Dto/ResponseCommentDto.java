package com.inProject.in.domain.Comment.Dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseCommentDto {
    private Long id;
    private String user_id;
    private String board_id;
    private String text;
}
