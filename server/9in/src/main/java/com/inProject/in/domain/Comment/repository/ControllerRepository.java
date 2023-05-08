package com.inProject.in.domain.Comment.repository;

import com.inProject.in.domain.Comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControllerRepository extends JpaRepository<Comment, Long> {
}
