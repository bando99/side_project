package com.inProject.in.domain.Board.service;

import com.inProject.in.domain.Board.Dto.*;
import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestUsingInBoardDto;
import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BoardService {
    ResponseBoardDto getBoard(Long id);

    ResponseBoardDto createBoard(Long user_id, RequestBoardDto requestBoardDto, List<RequestSkillTagDto> requestSkillTagDtoList, List<RequestUsingInBoardDto> requestRoleNeededDtoList);

    ResponseBoardDto updateBoard(Long id, RequestUpdateBoardDto requestUpdateBoardDto);

    void deleteBoard(Long id);

    List<ResponseBoardDto> getBoardList(Pageable pageable, RequestSearchBoardDto requestSearchBoardDto);

}
