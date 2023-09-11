package com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.repository;

import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantBoardRelationRepository extends JpaRepository<ApplicantBoardRelation, Long>, CustomApplicantBoardRepository {
}
