package com.inProject.in.domain.User.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomUserRepositoryImpl {
    private final JPAQueryFactory jpaQueryFactory;
    @Autowired
    public CustomUserRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
