package com.inProject.in.domain.Comment.service;

import com.inProject.in.domain.Comment.Dto.RequestCommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import com.inProject.in.domain.Comment.Dto.UpdateCommentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    ResponseCommentDto getComment(Long id);
    ResponseCommentDto createComment(RequestCommentDto requestCommentDto);
    ResponseCommentDto updateComment(Long id, UpdateCommentDto updateCommentDto);
    List<ResponseCommentDto> getCommentsInBoard(Pageable pageable, Long board_id);
    void deleteComment(Long id);
}
