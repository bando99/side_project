package com.inProject.in.domain.Comment.service;

import com.inProject.in.domain.Comment.Dto.CommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;

public interface CommentService {
    ResponseCommentDto getComment(Long id);
    ResponseCommentDto createComment(CommentDto commentDto);
    ResponseCommentDto updateComment(Long id, CommentDto commentDto);
    void deleteComment(Long id);
}
