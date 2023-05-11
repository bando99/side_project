package com.inProject.in.domain.Comment.service.impl;

import com.inProject.in.domain.Comment.Dto.CommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.Comment.repository.CommentRepository;
import com.inProject.in.domain.Comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    @Override
    public ResponseCommentDto getComment(Long id) {
        Comment comment = commentRepository.findById(id).get();

        ResponseCommentDto responseCommentDto = ResponseCommentDto.builder()
                .id(comment.getId())
                .user_id(comment.getUser_id())
                .post_id(comment.getPost_id())
                .text(comment.getText())
                .build();

        return responseCommentDto;
    }

    @Override
    public ResponseCommentDto createComment(CommentDto commentDto) {
        Comment comment = Comment.builder()
                .user_id(commentDto.getUser_id())
                .post_id(commentDto.getPost_id())
                .text(commentDto.getText())
                .build();

        Comment savedComment = commentRepository.save(comment);

        ResponseCommentDto responseCommentDto = ResponseCommentDto.builder()
                .id(savedComment.getId())
                .user_id(savedComment.getUser_id())
                .post_id(savedComment.getPost_id())
                .text(savedComment.getText())
                .build();

        return responseCommentDto;
    }

    @Override
    public ResponseCommentDto updateComment(Long id, CommentDto commentDto) {
        Comment comment = commentRepository.findById(id).get();
        //댓글 수정은 내용과 수정 일자만 변경
        comment.setText(commentDto.getText());

        Comment updatedComment = commentRepository.save(comment);

        ResponseCommentDto responseCommentDto = ResponseCommentDto.builder()
                .id(updatedComment.getId())
                .user_id(updatedComment.getUser_id())
                .post_id(updatedComment.getPost_id())
                .text(updatedComment.getText())
                .build();

        return responseCommentDto;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
