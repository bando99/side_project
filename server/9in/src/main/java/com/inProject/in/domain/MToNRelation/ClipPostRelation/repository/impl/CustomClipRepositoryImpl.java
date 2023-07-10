package com.inProject.in.domain.MToNRelation.ClipPostRelation.repository.impl;

import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.QClipPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.repository.CustomClipRepositroy;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.Impl.CustomPostRepositoryImpl;
import com.inProject.in.domain.User.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

public class CustomClipRepositoryImpl implements CustomClipRepositroy {
    private final JPAQueryFactory jpaQueryFactory;
    QClipPostRelation qClipPostRelation = QClipPostRelation.clipPostRelation;
    @Autowired
    public CustomClipRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Boolean isExistClipedPost(User user, Post post) {

      ClipPostRelation query = jpaQueryFactory.selectFrom(qClipPostRelation)
                .where(qClipPostRelation.clipUser.eq(user),
                        qClipPostRelation.clipedPost.eq(post))
                .fetchFirst();

        //exists를 통해 좋아요가 돼있는 게시물인지 확인 가능하지만..
        //fetchCount가 발생하여 모든 데이터를 조회하는 연산이 발생해 성능저하. fetchFirst로 개선.

        return query != null;
    }

    @Override
    public Optional<ClipPostRelation> findClipedPost(User user, Post post) {

        ClipPostRelation query = jpaQueryFactory.selectFrom(qClipPostRelation)
                .where(qClipPostRelation.clipedPost.eq(post),
                        qClipPostRelation.clipUser.eq(user))
                .fetchOne();

        return Optional.of(query);
    }


}
