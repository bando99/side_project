package com.inProject.in.domain.MToNRelation.ClipBoardRelation.repository;

import com.inProject.in.domain.MToNRelation.ClipBoardRelation.entity.ClipBoardRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClipBoardRelationRepository extends JpaRepository<ClipBoardRelation, Long>, CustomClipRepository {
}
