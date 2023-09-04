package com.inProject.in.domain.Comment.service.impl;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.Comment.Dto.RequestCommentDto;
import com.inProject.in.domain.Comment.Dto.ResponseCommentDto;
import com.inProject.in.domain.Comment.Dto.UpdateCommentDto;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.Comment.repository.CommentRepository;
import com.inProject.in.domain.Comment.service.CommentService;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private CommentRepository commentRepository;
    private final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
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
                .comment_id(comment.getId())
                .text(comment.getText())
                .build();

        return responseCommentDto;
    }

    @Override
    public ResponseCommentDto createComment(RequestCommentDto requestCommentDto) {

        Long user_id = requestCommentDto.getUser_id();
        Long board_id = requestCommentDto.getBoard_id();

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("createComment에서 유효하지 않은 user id : " + user_id));

        Board board = boardRepository.findById(board_id)
                .orElseThrow(() -> new IllegalArgumentException("createComment에서 유효하지 않은 board id : " + board_id));

        board.setComment_cnt(board.getComment_cnt() + 1);

//        Comment comment = Comment.builder()
//                .user(user)
//                .board(board)
//                .text(requestCommentDto.getText())
//                .build();

        Comment comment = requestCommentDto.toEntity(user, board);

        Comment savedComment = commentRepository.save(comment);
        Long savedId = savedComment.getId();
        log.info("CreateComment in commentService ==> comment id : " + savedId);

        ResponseCommentDto responseCommentDto = new ResponseCommentDto(savedComment);

        return responseCommentDto;
    }

    @Override
    @PreAuthorize(("#comment.user.username == authentication.principal.username")  )
    public ResponseCommentDto updateComment(Long id, UpdateCommentDto updateCommentDto) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("updqteComment에서 유효하지 않은 comment id : " + id));

        comment.updateComment(updateCommentDto);
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
    @PreAuthorize("#comment.user.username == authentication.principle.username or hasRole('ROLE_ADMIN')")
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("deleteComment에서 유효하지 않은 comment id : " + id));

        commentRepository.delete(comment);
    }
}
