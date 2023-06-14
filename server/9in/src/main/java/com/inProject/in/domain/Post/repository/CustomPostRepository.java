package com.inProject.in.domain.Post.repository;

import com.inProject.in.domain.Post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import javax.print.DocFlavor;
import java.util.List;

public interface CustomPostRepository {
    Page<Post> findPosts(Pageable pageable, String user_id, String title, String type, List<String> tags);

}
