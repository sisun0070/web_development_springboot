package me.ahngeunsu.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;


    @Column(name = "refresh_token", nullable = false)
    private String refreshToekn;

    public RefreshToken(Long userId, String refreshToekn) {
        this.userId = userId;
        this.refreshToekn = refreshToekn;
    }
    // 얘가 어떤 작용을 하는지는 리프레시 토큰 정의 부분 읽어주세요
    public RefreshToken update(String refreshToekn) {
        this.refreshToekn = refreshToekn;
        return this;
    }
    /*
        repository package -> RefreshTokenRepository.java
     */
}
