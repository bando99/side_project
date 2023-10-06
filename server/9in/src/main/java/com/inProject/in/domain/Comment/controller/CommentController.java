package com.inProject.in.domain.Comment.controller;

import com.inProject.in.Global.exception.CustomException;
import com.inProject.in.domain.Comment.Dto.RequestCommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import com.inProject.in.domain.Comment.Dto.UpdateCommentDto;
import com.inProject.in.domain.Comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@Tag(name = "comment", description = "댓글 관련 api")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    
    @GetMapping()
    @Operation(summary = "댓글 조회", description = "댓글들을 조회합니다. 사용할 일은 잘 없을 것.")
    public ResponseEntity<List<ResponseCommentDto>> getComments(@PageableDefault(size = 8) Pageable pageable,
                                                          @RequestParam  Long board_id){
        try{
            List<ResponseCommentDto> commentDtoList =  commentService.getCommentsInBoard(pageable, board_id);

            return ResponseEntity.status(HttpStatus.OK).body(commentDtoList);
        }catch (CustomException e){
            throw e;
        }
    }

    @PostMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    @Operation(summary = "댓글 생성", description = "댓글을 게시글에 생성합니다.")
    public ResponseEntity<ResponseCommentDto> createComment(@RequestBody RequestCommentDto requestCommentDto, HttpServletRequest request){

        try{
            ResponseCommentDto responseCommentDto = commentService.createComment(requestCommentDto, request);

            return ResponseEntity.status(HttpStatus.OK).body(responseCommentDto);
        }catch(CustomException e){
            throw e;
        }

    }

    @PutMapping("/{comment_id}")
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    @Parameter(name = "comment_id", description = "댓글 ID", in = ParameterIn.PATH, schema = @Schema(type = "integer", format = "int64"))
    @Operation(summary = "댓글 수정", description = "댓글을 수정합니다.")
    public ResponseEntity<ResponseCommentDto> updateComment(@PathVariable(name = "comment_id") Long comment_id,
                                                            @RequestBody UpdateCommentDto updateCommentDto,
                                                            HttpServletRequest request) throws CustomException{
        try{
            ResponseCommentDto responseCommentDto = commentService.updateComment(comment_id, updateCommentDto, request);

            return ResponseEntity.status(HttpStatus.OK).body(responseCommentDto);
        }catch (CustomException e){
            throw e;
        }

    }

    @DeleteMapping("{comment_id}")
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    @Parameter(name = "comment_id", description = "댓글 ID", in = ParameterIn.PATH, schema = @Schema(type = "integer", format = "int64"))
    @Operation(summary = "댓글 삭제", description = "댓글을 삭제합니다.")
    public ResponseEntity<String> deleteComment(@PathVariable(name = "comment_id") Long comment_id, HttpServletRequest request) throws CustomException{
        try{
            commentService.deleteComment(comment_id, request);

            return ResponseEntity.status(HttpStatus.OK).body("댓글 삭제 완료");
        }catch (CustomException e){
            throw e;
        }

    }
}
