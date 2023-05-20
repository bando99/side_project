package com.inProject.in.domain.Comment.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {
    private String user_id;
    private String post_id;
    private String text;
}
