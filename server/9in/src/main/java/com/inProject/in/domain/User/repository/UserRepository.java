package com.inProject.in.domain.User.repository;

import com.inProject.in.domain.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
