package com.inProject.in.domain.User.repository;

import com.inProject.in.domain.User.entity.User;

import java.util.List;

public interface CustomUserRepository {
    List<User> findSomeUser();
}
