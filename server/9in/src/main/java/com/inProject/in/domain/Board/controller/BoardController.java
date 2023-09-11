package com.inProject.in.domain.Board.controller;

import com.inProject.in.domain.Board.Dto.*;
import com.inProject.in.domain.Board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
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
@Tag(name = "board", description = "게시글 관련 api")
public class BoardController {
    private BoardService boardService;

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/{board_id}")
    @Operation(summary = "게시글 조회", description = "게시글 하나를 조회합니다.")
    public ResponseEntity<ResponseBoardDto> getBoard(@PathVariable Long board_id){

        ResponseBoardDto responseBoardDto = boardService.getBoard(board_id);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }

    @GetMapping()
    @Operation(summary = "게시글 리스트 조회", description = "게시글 리스트를 페이지 단위로 가져옵니다.")
    public ResponseEntity<List<ResponseBoardListDto>> getBoards(@PageableDefault(size = 8) Pageable pageable,
                                                     RequestSearchBoardDto requestSearchBoardDto){

        List<ResponseBoardListDto> responseBoardDtoList = boardService.getBoardList(pageable, requestSearchBoardDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDtoList);
    }

    @PostMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)   //swagger에서 헤더로 토큰을 전송하기 위해 입력창을 만든다.
    @Operation(summary = "게시글 생성", description = "게시글 하나를 작성합니다.")
    public ResponseEntity<ResponseBoardDto> createBoard(@RequestBody RequestCreateBoardDto requestCreateBoardDto, HttpServletRequest request){

        ResponseBoardDto responseBoardDto = boardService.createBoard(requestCreateBoardDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }

    @PutMapping("/{board_id}")
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    @Operation(summary = "게시글 수정", description = "게시글 하나를 업데이트 합니다.")
    public ResponseEntity<ResponseBoardDto> updateBoard(@PathVariable Long board_id,
                                                        @RequestBody RequestUpdateBoardDto requestUpdateBoardDto,
                                                        HttpServletRequest request
    ){

        ResponseBoardDto responseBoardDto = boardService.updateBoard(board_id, requestUpdateBoardDto, request);
        return null;
    }

    @DeleteMapping("/{board_id}")
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    @Parameter(name = "board_id", description = "게시글 ID", in = ParameterIn.PATH, schema = @Schema(type = "integer", format = "int64"))
    @Operation(summary = "게시글 삭제", description = "게시글 하나를 삭제합니다.")
    public ResponseEntity<String> deleteBoard(@PathVariable(name = "board_id") Long board_id, HttpServletRequest request){
        log.info("BoardController deleteBoard ==> header : " + request.getRequestURI());
        boardService.deleteBoard(board_id, request);
        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 게시글 삭제");
    }

}
