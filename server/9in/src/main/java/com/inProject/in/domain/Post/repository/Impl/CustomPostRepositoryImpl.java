package com.inProject.in.domain.Post.repository.Impl;

import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.entity.QPost;
import com.inProject.in.domain.Post.repository.CustomPostRepository;
import com.inProject.in.domain.User.repository.Impl.CustomUserRepositoryImpl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.lang.reflect.Type;
import java.util.List;

public class CustomPostRepositoryImpl implements CustomPostRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QPost qPost = QPost.post;
    @Autowired
    public CustomPostRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory =jpaQueryFactory;
    }

    //Paging 사용. service에서 사용할 때 PageRequest 사용해야 함.

    private JPAQuery<Long> getCount(){
        JPAQuery<Long> count = jpaQueryFactory
                .select(qPost.count())
                .from(qPost);
        return count;
    }

    @Override
    public Page<Post> findPosts(Pageable pageable, String user_id, String title, String type) {

        List<Post> content = jpaQueryFactory
                .selectFrom(qPost)
                .where(UserIdEq(user_id), TitleEq(title), TypeEq(type))
                .orderBy(qPost.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = getCount();
        return PageableExecutionUtils.getPage(content, pageable, () -> count.fetchOne());
    }

    private BooleanExpression UserIdEq(String user_id){
        return user_id.isBlank() != true ? qPost.user.user_id.eq(user_id) : null;
    }

    private BooleanExpression TitleEq(String title){
        return title.isBlank() != true ? qPost.title.eq(title) : null;
    }

    private BooleanExpression TypeEq(String type){
        return type.isBlank() != true ? qPost.type.eq(type) : null;
    }
}
