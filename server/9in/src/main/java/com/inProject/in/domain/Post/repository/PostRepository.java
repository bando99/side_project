package com.inProject.in.domain.Post.repository;

import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
