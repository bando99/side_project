package com.inProject.in.domain.Post.repository.Impl;

import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.QClipPostRelation;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.QTagPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.entity.QPost;
import com.inProject.in.domain.Post.repository.CustomPostRepository;
import com.inProject.in.domain.SkillTag.entity.QSkillTag;
import com.inProject.in.domain.User.entity.QUser;
import com.inProject.in.domain.User.entity.User;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;


import java.util.List;


public class CustomPostRepositoryImpl implements CustomPostRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QPost qPost = QPost.post;
    QSkillTag qSkillTag = QSkillTag.skillTag;
    QTagPostRelation qTagPostRelation = QTagPostRelation.tagPostRelation;
    QClipPostRelation qClipPostRelation = QClipPostRelation.clipPostRelation;
    QUser qUser = QUser.user;

    @Autowired
    public CustomPostRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory =jpaQueryFactory;
    }

    private JPAQuery<Long> getCount(){
        JPAQuery<Long> count = jpaQueryFactory
                .select(qPost.count())
                .from(qPost);
        return count;
    }

    @Override
    public Page<Post> findPosts(Pageable pageable, String user_id, String title, String type, List<String> tags) {

        List<Post> content = jpaQueryFactory
                .selectFrom(qPost)
                .where(UserIdEq(user_id), TitleEq(title), TypeEq(type), TagsEq(tags))
                .orderBy(qPost.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = getCount();
        return PageableExecutionUtils.getPage(content, pageable, () -> count.fetchOne());
    }

    @Override
    public Page<Post> searchPostsByCliped(Pageable pageable, User user) {
//        List<Post> content = jpaQueryFactory
//                .selectFrom(qPost)
//                .where(ClipedEq(user))
//                .orderBy(qPost.id.desc())
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();

        List<Post> content = jpaQueryFactory
                .selectFrom(qPost)
                .join(qPost.clipPostRelationList, qClipPostRelation)
                .where(qClipPostRelation.clipUser.id.eq(user.getId()))
                .orderBy(qPost.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = getCount();
        return PageableExecutionUtils.getPage(content, pageable, () -> count.fetchOne());

    }


    private BooleanExpression UserIdEq(String user_id){ return user_id.isBlank() != true ? qPost.author.user_id.eq(user_id) : null; }

    private BooleanExpression TitleEq(String title){
        return title.isBlank() != true ? qPost.title.eq(title) : null;
    }

    private BooleanExpression TypeEq(String type){
        return type.isBlank() != true ? qPost.type.eq(type) : null;
    }

    private BooleanExpression TagsEq(List<String> tags) {
        if (tags.isEmpty() == true) return null;

        BooleanExpression combinedExpression = Expressions.asBoolean(true).isTrue();


        for(String tag : tags){
//            QPost subqPost = new QPost("subqPost");

//            Predicate tagQuery = qPost.id.in(jpaQueryFactory
//                    .select(subqPost.id)
//                    .from(subqPost)
//                    .join(subqPost.tagPostRelationList, qTagPostRelation)
//                    .join(qTagPostRelation.skillTag, qSkillTag)
//                    .where(qSkillTag.name.eq(tag)));

            Predicate tagQuery = qPost.id.in(
                    jpaQueryFactory.select(qTagPostRelation.post.id)
                            .from(qTagPostRelation)
                            .join(qTagPostRelation.skillTag, qSkillTag)
                            .where(qSkillTag.name.eq(tag))
            );

            combinedExpression = combinedExpression.and(tagQuery);
        }

        return combinedExpression;
    }

    private BooleanExpression ClipedEq(User user){
        if (user == null) return null;

        BooleanExpression clipedquery = qPost.id.in(jpaQueryFactory
                .select(qClipPostRelation.clipedPost.id)
                .from(qClipPostRelation)
                .join(qClipPostRelation.clipUser, qUser)
                .where(qUser.id.eq(user.getId())));


        return clipedquery;
    }
}
