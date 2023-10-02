package com.inProject.in.domain.User.repository;

import com.inProject.in.domain.User.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomUserRepository {

    List<User> findSomeUser();
    User findByIdAndPassword(Long id, String password );
}
