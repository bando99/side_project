package com.inProject.in.domain.RoleNeeded.repository;

import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleNeededRepository extends JpaRepository<RoleNeeded, Long>, CustomRoleNeededRepository {
    @Query("SELECT r FROM RoleNeeded as r WHERE r.name = :name")
    Optional<RoleNeeded> findRoleByName(@Param("name") String name);
}
