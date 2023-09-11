package com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.repository.Impl;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.QApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.repository.CustomApplicantBoardRepository;
import com.inProject.in.domain.User.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomApplicantBoardRepositoryImpl implements CustomApplicantBoardRepository {
    private QApplicantBoardRelation qApplicantBoardRelation = QApplicantBoardRelation.applicantBoardRelation;
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public CustomApplicantBoardRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }
    @Override
    public Boolean isExistApplicantBoard(User user, Board board) {
        ApplicantBoardRelation query = jpaQueryFactory.selectFrom(qApplicantBoardRelation)
                .where(qApplicantBoardRelation.board_applicant.eq(user),
                        qApplicantBoardRelation.board.eq(board))
                .fetchFirst();

        return query != null;
    }

    @Override
    public Optional<ApplicantBoardRelation> findApplicantBoard(User user, Board board) {
        ApplicantBoardRelation query = jpaQueryFactory.selectFrom(qApplicantBoardRelation)
                .where(qApplicantBoardRelation.board.eq(board),
                        qApplicantBoardRelation.board_applicant.eq(user))
                .fetchOne();

        return Optional.of(query);
    }
}
