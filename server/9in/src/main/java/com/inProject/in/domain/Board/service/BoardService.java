package com.inProject.in.domain.Board.service;

import com.inProject.in.domain.Board.Dto.BoardDto;
import com.inProject.in.domain.Board.Dto.ResponseBoardDto;
import com.inProject.in.domain.RoleNeeded.Dto.RoleNeededDto;
import com.inProject.in.domain.SkillTag.Dto.SkillTagDto;
import com.inProject.in.domain.User.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BoardService {
    ResponseBoardDto getBoard(Long id);

    ResponseBoardDto createBoard(BoardDto boardDto, List<SkillTagDto> skillTagDtoList, List<RoleNeededDto> roleNeededDtoList);

    ResponseBoardDto updateBoard(Long id, BoardDto boardDto);

    void deleteBoard(Long id);

    List<ResponseBoardDto> getBoardList(Pageable pageable, String user_id, String title, String type, List<String> tags);

}
