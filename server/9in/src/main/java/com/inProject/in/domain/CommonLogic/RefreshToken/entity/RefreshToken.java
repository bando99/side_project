package com.inProject.in.domain.CommonLogic.RefreshToken.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Ref;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshToken extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = false)
    private String refreshToken;

    public RefreshToken(User user, String refreshToken){
        this.user = user;
        this.refreshToken = refreshToken;
    }
    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

}
