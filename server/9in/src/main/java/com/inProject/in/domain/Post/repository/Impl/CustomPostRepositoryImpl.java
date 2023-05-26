package com.inProject.in.domain.Post.repository.Impl;

import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.entity.QPost;
import com.inProject.in.domain.Post.repository.CustomPostRepository;
import com.inProject.in.domain.User.repository.Impl.CustomUserRepositoryImpl;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

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
    public Page<Post> findAllPost(Pageable pageable) {

        List<Post> content = jpaQueryFactory
                .selectFrom(qPost)
                .orderBy(qPost.createAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = getCount();

        return PageableExecutionUtils.getPage(content, pageable, () -> count.fetchOne());  //count쿼리가 필요없을 때 사용하지 않는 최적화 적용.
        //return new PageImpl(content, pageable, count);
    }
    @Override
    public Page<Post> findUserPost(String userId, Pageable pageable) {
        List<Post> content = jpaQueryFactory
                .selectFrom(qPost)
                .where(qPost.user.user_id.eq(userId))
                .orderBy(qPost.createAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = getCount();
        return PageableExecutionUtils.getPage(content, pageable, () -> count.fetchOne());
    }

    @Override
    public Page<Post> findByPostTitle(String input_title, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Post> findByType(String input_type, Pageable pageable) {
        return null;
    }


}
