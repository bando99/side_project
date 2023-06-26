package com.inProject.in.domain.MToNRelation.ApplicantPostRelation.repository;

import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantPostRelationRepository extends JpaRepository<ApplicantPostRelation, Long>, CustomApplicantPostRepository {
}
