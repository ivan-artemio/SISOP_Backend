package com.sisop.hexagonal.auth.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Base64;
import java.util.Date;

import com.sisop.hexagonal.auth.domain.AuthenticationTokenProvider;
import com.sisop.hexagonal.auth.domain.Token;
import com.sisop.hexagonal.users.domain.model.Login;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationTokenProvider implements AuthenticationTokenProvider {
    @Value("${security.jwt.token.secret-key:default-secret-key}")
    private String secretKey;

    public void JwtTokenProvider(final String secretKey) {
        // this is to avoid having the raw secret key available in the JVM
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    @Override
    public String createToken(String login) {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + 86400000); // 24 hours

        final Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                        .withSubject(login)
                        .withIssuedAt(now)
                        .withExpiresAt(validity)
                        .sign(algorithm);
    }

    @Override
    public Login validateToken(String token) {
        final Algorithm algorithm = Algorithm.HMAC256(secretKey);
        final JWTVerifier verifier = JWT.require(algorithm).build();
        final DecodedJWT decoded = verifier.verify(token);
        return new Login(decoded.getSubject());
    }
}
