package com.inProject.in.domain.MToNRelation.ClipPostRelation.repository;

import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;

import java.util.Optional;

public interface CustomClipRepositroy {
    Boolean isExistClipedPost(User user, Post post);
    Optional<ClipPostRelation> findClipedPost(User user, Post post);
}
