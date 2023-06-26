package com.inProject.in.domain.RoleNeeded.repository.Impl;

import com.inProject.in.domain.RoleNeeded.entity.QRoleNeeded;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.CustomRoleNeededRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRoleNeededRepositoryImpl implements CustomRoleNeededRepository {

    QRoleNeeded qRoleNeeded = QRoleNeeded.roleNeeded;
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public CustomRoleNeededRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
