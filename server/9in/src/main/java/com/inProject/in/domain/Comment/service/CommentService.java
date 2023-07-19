package com.inProject.in.domain.Comment.service;

import com.inProject.in.domain.Comment.Dto.CommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    ResponseCommentDto getComment(Long id);
    ResponseCommentDto createComment(CommentDto commentDto, Long user_id, Long board_id);
    ResponseCommentDto updateComment(Long id, CommentDto commentDto);
    List<ResponseCommentDto> getCommentsInBoard(Pageable pageable, Long board_id);
    void deleteComment(Long id);
}
