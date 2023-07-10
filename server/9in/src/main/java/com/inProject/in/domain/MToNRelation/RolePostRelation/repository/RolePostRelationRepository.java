package com.inProject.in.domain.MToNRelation.RolePostRelation.repository;

import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RolePostRelationRepository extends JpaRepository<RolePostRelation, Long> {

    @Query("SELECT r FROM rolePostRelation as r WHERE r.post_id == :post_id AND r.role_id == :role_id")
    Optional<RolePostRelation> findRelationByRoleId(@Param("post_id") Long post_id,
                                                    @Param("role_id") Long role_id);
}
