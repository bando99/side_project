package com.inProject.in.domain.Comment.repository;

import com.inProject.in.domain.Comment.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomCommentRepository {
    Page<Comment> findCommentsByBoardId(Pageable pageable, Long board_id);
}
