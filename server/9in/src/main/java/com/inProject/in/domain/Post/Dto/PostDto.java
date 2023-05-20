package com.inProject.in.domain.Post.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PostDto {
    private Long id;
    private String user_id;
    private String type;
    private String title;
    private String text;
}


