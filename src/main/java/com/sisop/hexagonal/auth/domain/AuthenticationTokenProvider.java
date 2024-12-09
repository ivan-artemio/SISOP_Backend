package com.sisop.hexagonal.auth.domain;

import com.sisop.hexagonal.users.domain.model.Login;

public interface AuthenticationTokenProvider {
    String createToken(String login);

    Login validateToken(String token);
}
