package com.inProject.in.domain.MToNRelation.RoleBoardRelation.repository;

import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleBoardRelationRepository extends JpaRepository<RoleBoardRelation, Long> {


    @Query("SELECT r FROM RoleBoardRelation as r WHERE r.board.id = :board_id AND r.roleNeeded.id = :role_id")
    Optional<RoleBoardRelation> findRelationById(@Param("board_id") Long board_id,
                                                 @Param("role_id") Long role_id);
}
