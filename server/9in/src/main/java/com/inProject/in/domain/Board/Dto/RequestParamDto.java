package com.inProject.in.domain.Board.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestParamDto {
    private String user_id;
    private String title;
    private String type;
    private List<String> tags;
}