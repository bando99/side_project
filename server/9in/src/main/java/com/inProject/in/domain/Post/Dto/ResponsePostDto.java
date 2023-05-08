package com.inProject.in.domain.Post.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponsePostDto {
    private Long id;
    private String user_id;
    private String title;
    private String text;
}
