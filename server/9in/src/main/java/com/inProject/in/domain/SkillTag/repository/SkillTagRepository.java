package com.inProject.in.domain.SkillTag.repository;

import com.inProject.in.domain.SkillTag.entity.SkillTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SkillTagRepository extends JpaRepository<SkillTag, Long> {

    @Query("SELECT s FROM SkillTag s WHERE s.name = :name")
    Optional<SkillTag> findTagByName(@Param("name") String name);
}
