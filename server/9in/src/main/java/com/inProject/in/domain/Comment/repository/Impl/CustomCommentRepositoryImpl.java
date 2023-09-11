package com.inProject.in.domain.Comment.repository.Impl;

import com.inProject.in.domain.Board.entity.QBoard;
import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.Comment.entity.QComment;
import com.inProject.in.domain.Comment.repository.CustomCommentRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

public class CustomCommentRepositoryImpl implements CustomCommentRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QBoard qBoard = QBoard.board;
    QComment qComment = QComment.comment;

    @Autowired
    public CustomCommentRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private JPAQuery<Long> getCount(Long board_id){
        JPAQuery<Long> count = jpaQueryFactory
                .select(qComment.count())
                .from(qComment)
                .where(qComment.board.id.eq(board_id));

        return count;
    }

    @Override
    public Page<Comment> findCommentsByBoardId(Pageable pageable, Long board_id) {
        List<Comment> content = jpaQueryFactory.selectFrom(qComment)
                .where(qComment.board.id.eq(board_id))
                .orderBy(qComment.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = getCount(board_id);
        return PageableExecutionUtils.getPage(content, pageable, () -> count.fetchOne());
    }


}
