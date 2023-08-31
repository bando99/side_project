package com.inProject.in.domain.Comment.controller;

import com.inProject.in.domain.Comment.Dto.RequestCommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import com.inProject.in.domain.Comment.Dto.UpdateCommentDto;
import com.inProject.in.domain.Comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Operation(summary = "댓글 조회", description = "댓글을 하나 조회합니다. 사용할 일은 잘 없을 것.")
    public ResponseEntity<List<ResponseCommentDto>> getComments(@PageableDefault(size = 8) Pageable pageable,
                                                          @RequestParam  Long board_id){

        List<ResponseCommentDto> commentDtoList =  commentService.getCommentsInBoard(pageable, board_id);

        return ResponseEntity.status(HttpStatus.OK).body(commentDtoList);
    }

    @PostMapping()
    @Operation(summary = "댓글 생성", description = "댓글을 게시글에 생성합니다.")
    public ResponseEntity<ResponseCommentDto> createComment(@RequestBody RequestCommentDto requestCommentDto){

        ResponseCommentDto responseCommentDto = commentService.createComment(requestCommentDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseCommentDto);
    }

    @PutMapping("/{comment_id}")
    @Operation(summary = "댓글 수정", description = "댓글을 수정합니다.")
    public ResponseEntity<ResponseCommentDto> updateComment(@PathVariable Long comment_id,
                                                            @RequestBody UpdateCommentDto updateCommentDto) throws Exception{

        ResponseCommentDto responseCommentDto = commentService.updateComment(comment_id, updateCommentDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseCommentDto);
    }

    @DeleteMapping()
    @Operation(summary = "댓글 삭제", description = "댓글을 삭제합니다.")
    public ResponseEntity<String> deleteComment(@RequestParam Long comment_id) throws Exception{

        commentService.deleteComment(comment_id);

        return ResponseEntity.status(HttpStatus.OK).body("댓글 삭제 완료");
    }
}
