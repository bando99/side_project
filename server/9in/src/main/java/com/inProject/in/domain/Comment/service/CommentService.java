package com.inProject.in.domain.Comment.service;

import com.inProject.in.domain.Comment.Dto.CommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;

import java.util.List;

public interface CommentService {
    ResponseCommentDto getComment(Long id);
    ResponseCommentDto createComment(CommentDto commentDto);
    ResponseCommentDto updateComment(Long id, CommentDto commentDto);
    List<ResponseCommentDto> findCommentsInBoard();
    void deleteComment(Long id);
}
