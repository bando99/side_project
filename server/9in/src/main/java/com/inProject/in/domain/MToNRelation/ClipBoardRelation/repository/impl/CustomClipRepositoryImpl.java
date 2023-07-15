package com.inProject.in.domain.MToNRelation.ClipBoardRelation.repository.impl;

import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.QClipBoardRelation;
import com.inProject.in.domain.MToNRelation.ClipBoardRelation.repository.CustomClipRepositroy;
import com.inProject.in.domain.User.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomClipRepositoryImpl implements CustomClipRepositroy {
    private final JPAQueryFactory jpaQueryFactory;
    QClipBoardRelation qClipBoardRelation = QClipBoardRelation.clipBoardRelation;
    @Autowired
    public CustomClipRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Boolean isExistClipedPost(User user, Board board) {

      ClipBoardRelation query = jpaQueryFactory.selectFrom(qClipBoardRelation)
                .where(qClipBoardRelation.clipUser.eq(user),
                        qClipBoardRelation.clipedBoard.eq(board))
                .fetchFirst();

        //exists를 통해 좋아요가 돼있는 게시물인지 확인 가능하지만..
        //fetchCount가 발생하여 모든 데이터를 조회하는 연산이 발생해 성능저하. fetchFirst로 개선.

        return query != null;
    }

    @Override
    public Optional<ClipBoardRelation> findClipedPost(User user, Board board) {

        ClipBoardRelation query = jpaQueryFactory.selectFrom(qClipBoardRelation)
                .where(qClipBoardRelation.clipedBoard.eq(board),
                        qClipBoardRelation.clipUser.eq(user))
                .fetchOne();

        return Optional.of(query);
    }


}
