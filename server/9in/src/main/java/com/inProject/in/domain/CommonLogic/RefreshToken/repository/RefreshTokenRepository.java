package com.inProject.in.domain.CommonLogic.RefreshToken.repository;

import com.inProject.in.domain.CommonLogic.RefreshToken.entity.RefreshToken;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    @Query("SELECT s FROM RefreshToken AS s WHERE s.user.username = :username")
    Optional<RefreshToken> getByUsername(@Param("username") String username);
}
