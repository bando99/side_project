package com.inProject.in.domain.Post.repository;

import com.inProject.in.domain.Post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface CustomPostRepository {
    Page<Post> findAllPost(Pageable pageable);
    Page<Post> findUserPost(String user_id, Pageable pageable);  //회원명으로 게시글 검색
    Page<Post> findByPostTitle(String input_title, Pageable pageable); //제목으로 게시글 검색
    Page<Post> findByType(String input_type, Pageable pageable); //스터디, 프로젝트 필터링

}
