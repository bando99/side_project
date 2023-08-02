package com.inProject.in.domain.Comment.controller;

import com.inProject.in.domain.Comment.Dto.CommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import com.inProject.in.domain.Comment.Dto.UpdateCommentDto;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.Comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    
    @GetMapping()
    public ResponseEntity<List<ResponseCommentDto>> getComments(@PageableDefault(size = 8) Pageable pageable,
                                                          @RequestParam  Long board_id){

        List<ResponseCommentDto> commentDtoList =  commentService.getCommentsInBoard(pageable, board_id);

        return ResponseEntity.status(HttpStatus.OK).body(commentDtoList);
    }

    @PostMapping()
    public ResponseEntity<ResponseCommentDto> createComment(@RequestBody CommentDto commentDto){

        ResponseCommentDto responseCommentDto = commentService.createComment(commentDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseCommentDto);
    }

    @PutMapping("/{comment_id}")
    public ResponseEntity<ResponseCommentDto> updateComment(@PathVariable Long comment_id,
                                                            @RequestBody UpdateCommentDto updateCommentDto) throws Exception{

        ResponseCommentDto responseCommentDto = commentService.updateComment(comment_id, updateCommentDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseCommentDto);
    }

    @DeleteMapping("/{comment_id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long comment_id) throws Exception{

        commentService.deleteComment(comment_id);

        return ResponseEntity.status(HttpStatus.OK).body("댓글 삭제 완료");
    }
}
