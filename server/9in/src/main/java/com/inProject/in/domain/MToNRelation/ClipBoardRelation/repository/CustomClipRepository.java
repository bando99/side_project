package com.inProject.in.domain.MToNRelation.ClipBoardRelation.repository;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.User.entity.User;

import java.util.Optional;

public interface CustomClipRepository {
    Boolean isExistClipedBoard(User user, Board board);
    Optional<ClipBoardRelation> getClipedBoard(User user, Board board);
}

