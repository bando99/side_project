package com.inProject.in.domain.Post.repository;

import com.inProject.in.domain.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<User, Long> {

}
