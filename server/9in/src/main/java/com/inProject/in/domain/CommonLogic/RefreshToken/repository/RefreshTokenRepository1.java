package com.inProject.in.domain.CommonLogic.RefreshToken.repository;

import com.inProject.in.domain.CommonLogic.RefreshToken.entity.RefreshToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class RefreshTokenRepository1 {
    private final RedisTemplate redisTemplate;
    private final Logger log = LoggerFactory.getLogger(RefreshTokenRepository1.class);

    @Autowired
    public RefreshTokenRepository1(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public void save(RefreshToken refreshToken){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();  //opsFor은 특정 컬렉션의 작업(operation)들을 호출할 수 있는 인터페이스를 반환. 이것은 string을 위한 것.

        if(!Objects.isNull(valueOperations.get(refreshToken.getUsername()))){
            redisTemplate.delete(refreshToken.getUsername());
            log.info("refreshToken Repository save -> update ");
        }
        valueOperations.set(refreshToken.getUsername(), refreshToken.getRefreshToken());
        redisTemplate.expire(refreshToken.getUsername(), 60 * 60 * 24, TimeUnit.SECONDS);
    }

    public Optional<RefreshToken> findByUsername(String username){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String refreshToken = valueOperations.get(username);

        if(refreshToken== null){
            return Optional.empty();
        }
        else{
            return Optional.of(new RefreshToken(username, refreshToken));
        }
    }

//    public Optional<RefreshToken> findByRefreshToken(String refreshToken){
//
//      //  ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
//        ValueOperations<String, String> valueOperations = redisTemplate.
//        String username = valueOperations.get(refreshToken);
//
//        if(refreshToken== null){
//            return Optional.empty();
//        }
//        else{
//            return Optional.of(new RefreshToken(username, refreshToken));
//        }
//    }



}
