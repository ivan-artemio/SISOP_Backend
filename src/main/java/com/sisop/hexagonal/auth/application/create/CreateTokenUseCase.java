package com.sisop.hexagonal.auth.application.create;

import com.sisop.hexagonal.auth.domain.AuthenticationTokenProvider;
import com.sisop.hexagonal.users.domain.model.Login;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTokenUseCase {

    AuthenticationTokenProvider authenticationTokenProvider;

    public String createToken(String login) {
        return authenticationTokenProvider.createToken(login);
    }
}
