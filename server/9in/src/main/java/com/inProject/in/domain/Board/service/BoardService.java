package com.inProject.in.domain.Board.service;

import com.inProject.in.domain.Board.Dto.*;
import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestUsingInBoardDto;
import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BoardService {
    ResponseBoardDto getBoard(Long id);

    ResponseBoardDto createBoard(RequestCreateBoardDto requestCreateBoardDto,
                                 HttpServletRequest request);

    ResponseBoardDto updateBoard(Long id, RequestUpdateBoardDto requestUpdateBoardDto, HttpServletRequest request);

    void deleteBoard(Long id, HttpServletRequest request);

    List<ResponseBoardListDto> getBoardList(Pageable pageable, RequestSearchBoardDto requestSearchBoardDto);
    List<ResponseBoardListDto> getClipedBoards(Pageable pageable, HttpServletRequest request);

}
