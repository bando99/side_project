package com.inProject.in.domain.MToNRelation.ClipBoardRelation.service.Impl;

import com.inProject.in.domain.MToNRelation.ClipBoardRelation.Dto.ResponseClipBoardRelationDto;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.repository.ClipBoardRelationRepository;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.service.ClipBoardRelationService;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ClipBoardRelationServiceImpl implements ClipBoardRelationService {

    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private ClipBoardRelationRepository clipBoardRelationRepository;

    private final Logger log = LoggerFactory.getLogger(ClipBoardRelationServiceImpl.class);

    @Autowired
    public ClipBoardRelationServiceImpl(UserRepository userRepository,
                                        BoardRepository boardRepository,
                                        ClipBoardRelationRepository clipBoardRelationRepository){

        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
        this.clipBoardRelationRepository = clipBoardRelationRepository;
    }


    @Override
    public ResponseClipBoardRelationDto insertClip(Long user_id, Long board_id){


        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("insert Clip에서 유효하지 않은 user id : " + user_id));

        Board board = boardRepository.findById(board_id)
                .orElseThrow(() -> new IllegalArgumentException("insert Clip에서 유효하지 않은 post id : " + board_id));

        log.info("Using insertClip in clip Service ==> board_id : " + board_id + " user_id : " + user_id);

        //유저가 누른 적 없는 게시물인지 확인.
        if(clipBoardRelationRepository.isExistClipedBoard(user, board) == false) {

            ClipBoardRelation clipBoardRelation = ClipBoardRelation.builder()
                    .clipUser(user)
                    .clipedBoard(board)
                    .build();

            ClipBoardRelation createRelation = clipBoardRelationRepository.save(clipBoardRelation);
            ResponseClipBoardRelationDto responseClipBoardRelationDto = new ResponseClipBoardRelationDto(createRelation);

            log.info("Insert Clip Post Relation ==> relation_id " + responseClipBoardRelationDto.getId());

            return responseClipBoardRelationDto;
        }

        return null;  //유저가 누른 적 있는 경우 null.
    }

    @Override
    public ResponseClipBoardRelationDto deleteClip(Long user_id, Long board_id) {

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("delete Clip에서 유효하지 않은 user id : " + user_id));

        Board board = boardRepository.findById(board_id)
                .orElseThrow(() -> new IllegalArgumentException("delete Clip에서 유효하지 않은 post id : " + board_id));

        ClipBoardRelation clipBoardRelation = clipBoardRelationRepository.getClipedBoard(user, board)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 등록이 되지 않은 게시글 ==> user id : " + user_id + " post id : " + board_id));

        log.info("Using deleteClip in clip service ==> board_id " + board_id + " user_id " + user_id);
        log.info("delete Clip Post Relation ==> relation_id " + clipBoardRelation.getId());

        clipBoardRelationRepository.delete(clipBoardRelation);
        return null;
    }


}
