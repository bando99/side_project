package com.inProject.in.domain.MToNRelation.ClipPostRelation.repository;

import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClipPostRelationRepository extends JpaRepository<ClipPostRelation, Long>, CustomClipRepositroy {
}
