package com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.repository;

import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.User.entity.User;

import java.util.Optional;

public interface CustomApplicantBoardRepository {
    Boolean isExistApplicantBoard(User user, Board board);
    Optional<ApplicantBoardRelation> findApplicantBoard(User user, Board board);
}
