package com.inProject.in.domain.MToNRelation.ApplicantPostRelation.repository.Impl;

import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.QApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.repository.CustomApplicantPostRepository;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomApplicantPostRepositoryImpl implements CustomApplicantPostRepository {
    private QApplicantPostRelation qApplicantPostRelation = QApplicantPostRelation.applicantPostRelation;
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public CustomApplicantPostRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }
    @Override
    public Boolean isExistApplicantPost(User user, Post post) {
        ApplicantPostRelation query = jpaQueryFactory.selectFrom(qApplicantPostRelation)
                .where(qApplicantPostRelation.post_applicant.eq(user),
                        qApplicantPostRelation.post.eq(post))
                .fetchFirst();

        return query != null;
    }

    @Override
    public Optional<ApplicantPostRelation> findApplicantPost(User user, Post post) {
        ApplicantPostRelation query = jpaQueryFactory.selectFrom(qApplicantPostRelation)
                .where(qApplicantPostRelation.post.eq(post),
                        qApplicantPostRelation.post_applicant.eq(user))
                .fetchOne();

        return Optional.of(query);
    }
}
