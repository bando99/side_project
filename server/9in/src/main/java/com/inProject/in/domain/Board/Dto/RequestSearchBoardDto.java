package com.inProject.in.domain.Board.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestSearchBoardDto {
    private String username = "";
    private String title = "";
    private String type = "";
    private List<String> tags = new ArrayList<>();
}