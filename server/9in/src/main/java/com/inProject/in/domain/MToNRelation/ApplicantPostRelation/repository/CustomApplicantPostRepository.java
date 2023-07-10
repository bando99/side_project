package com.inProject.in.domain.MToNRelation.ApplicantPostRelation.repository;

import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;

import java.util.Optional;

public interface CustomApplicantPostRepository {
    Boolean isExistApplicantPost(User user, Post post);
    Optional<ApplicantPostRelation> findApplicantPost(User user, Post post);
}
