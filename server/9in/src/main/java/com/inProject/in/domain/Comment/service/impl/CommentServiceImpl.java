package com.inProject.in.domain.Comment.service.impl;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.Comment.Dto.CommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.Comment.repository.CommentRepository;
import com.inProject.in.domain.Comment.service.CommentService;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    UserRepository userRepository;
    BoardRepository boardRepository;
    CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,
                              UserRepository userRepository,
                              BoardRepository boardRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public ResponseCommentDto getComment(Long id) {
        Comment comment = commentRepository.findById(id).get();

        ResponseCommentDto responseCommentDto = ResponseCommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .build();

        return responseCommentDto;
    }

    @Override
    public ResponseCommentDto createComment(CommentDto commentDto, Long user_id, Long board_id) {

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("createComment에서 유효하지 않은 user id : " + user_id));

        Board board = boardRepository.findById(board_id)
                .orElseThrow(() -> new IllegalArgumentException("createComment에서 유효하지 않은 board id : " + board_id));

        Comment comment = Comment.builder()
                .user(user)
                .board(board)
                .text(commentDto.getText())
                .build();

        Comment savedComment = commentRepository.save(comment);

        ResponseCommentDto responseCommentDto = new ResponseCommentDto(savedComment);

        return responseCommentDto;
    }

    @Override
    public ResponseCommentDto updateComment(Long id, CommentDto commentDto) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("updqteComment에서 유효하지 않은 comment id : " + id));

        comment.updateComment(commentDto);
        Comment updatedComment = commentRepository.save(comment);

        ResponseCommentDto responseCommentDto = new ResponseCommentDto(updatedComment);

        return responseCommentDto;
    }

    @Override
    public List<ResponseCommentDto> getCommentsInBoard(Pageable pageable, Long board_id) {

        Page<Comment> commentPage =  commentRepository.findCommentsByBoardId(pageable, board_id);
        List<Comment> commentList = commentPage.getContent();
        List<ResponseCommentDto> responseCommentDtoList = new ArrayList<>();

        for(Comment comment : commentList){
            ResponseCommentDto responseCommentDto = new ResponseCommentDto(comment);
            responseCommentDtoList.add(responseCommentDto);
        }

        return responseCommentDtoList;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
