package me.ahngeunsu.springbootdeveloper.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt")     // 자바 클래스에 프러퍼티값을 가져와 사용하는 애너테이션
public class JwtProperties {
    private String issuer;
    private String secretKey;

    /*
        이렇게 하면 issur 필드에서 application.yml에서 설정한 jwt.ussuer값이,
        secretKey에는 jwt.secret_Key 값이 매핑됩니다.
     */
}
