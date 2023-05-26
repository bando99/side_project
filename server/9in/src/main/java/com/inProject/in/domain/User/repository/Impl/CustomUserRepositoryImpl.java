package com.inProject.in.domain.User.repository.Impl;

import com.inProject.in.domain.User.Dto.UserDto;
import com.inProject.in.domain.User.entity.QUser;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.CustomUserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomUserRepositoryImpl {
    private final JPAQueryFactory jpaQueryFactory;
    @Autowired
    public CustomUserRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
