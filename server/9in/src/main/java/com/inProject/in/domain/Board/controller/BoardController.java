package com.inProject.in.domain.Board.controller;

import com.inProject.in.domain.Board.Dto.*;
import com.inProject.in.domain.Board.service.BoardService;
import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestUsingInBoardDto;
import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private BoardService boardService;

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/{board_id}")
    public ResponseEntity<ResponseBoardDto> getBoard(@PathVariable Long board_id){

        ResponseBoardDto responseBoardDto = boardService.getBoard(board_id);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseBoardDto>> getBoards(@PageableDefault(size = 8) Pageable pageable,
                                                     RequestSearchBoardDto requestSearchBoardDto){

        List<ResponseBoardDto> responseBoardDtoList = boardService.getBoardList(pageable, requestSearchBoardDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDtoList);
    }

    @PostMapping()
    public ResponseEntity<ResponseBoardDto> createBoard(@RequestBody RequestCreateBoardDto requestCreateBoardDto){

        RequestBoardDto requestBoardDto = requestCreateBoardDto.toBoardDto();
        Long user_id = requestCreateBoardDto.getUser_id();
        List<RequestSkillTagDto> requestSkillTagDtoList = new ArrayList<>();        //requestCreateDto에 requestSkilltagDto를 포함할까 고민중..
        List<RequestUsingInBoardDto> requestRoleNeededDtoList = requestCreateBoardDto.getRoleNeededDtoList();

        for(String tagName : requestCreateBoardDto.getTagNames()) {
            requestSkillTagDtoList.add(new RequestSkillTagDto(tagName));
        }

        ResponseBoardDto responseBoardDto = boardService.createBoard(user_id, requestBoardDto, requestSkillTagDtoList, requestRoleNeededDtoList);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }

    @PutMapping("/{board_id}")
    public ResponseEntity<ResponseBoardDto> updateBoard(@PathVariable Long board_id,
                                                        @RequestBody RequestUpdateBoardDto requestUpdateBoardDto){

        ResponseBoardDto responseBoardDto = boardService.updateBoard(board_id, requestUpdateBoardDto);
        return null;
    }

    @DeleteMapping("/{board_id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long board_id){
        boardService.deleteBoard(board_id);
        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 게시글 삭제");
    }

}
