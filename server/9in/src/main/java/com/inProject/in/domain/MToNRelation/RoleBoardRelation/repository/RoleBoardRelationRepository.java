package com.inProject.in.domain.MToNRelation.RoleBoardRelation.repository;

import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleBoardRelationRepository extends JpaRepository<RoleBoardRelation, Long> {

    @Query("SELECT r FROM rolePostRelation as r WHERE r.post_id == :post_id AND r.role_id == :role_id")
    Optional<RoleBoardRelation> findRelationById(@Param("post_id") Long post_id,
                                                     @Param("role_id") Long role_id);
}
