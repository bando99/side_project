package com.inProject.in.domain.CommonLogic.RefreshToken.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.sql.Ref;


@Getter
@Setter
@NoArgsConstructor
@Builder
@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24)   //단위는 초단위. 60초 뒤 데이터 삭제. 테스트를 위해 짧게 60초로 설정.
public class RefreshToken extends BaseEntity {
    @Id
    private String username;
    @Indexed
    private String refreshToken;

    public RefreshToken(String username, String refreshToken){
        this.username = username;
        this.refreshToken = refreshToken;
    }
    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

}
