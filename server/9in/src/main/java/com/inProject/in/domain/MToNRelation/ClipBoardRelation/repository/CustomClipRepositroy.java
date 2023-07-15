package com.inProject.in.domain.MToNRelation.ClipBoardRelation.repository;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.User.entity.User;

import java.util.Optional;

public interface CustomClipRepositroy {
    Boolean isExistClipedPost(User user, Board board);
    Optional<ClipBoardRelation> findClipedPost(User user, Board board);
}
