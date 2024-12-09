package com.sisop.hexagonal.auth.application.validate;

import java.util.Optional;
import com.sisop.hexagonal.auth.domain.AuthenticationTokenProvider;
import com.sisop.hexagonal.users.domain.model.Login;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.sisop.hexagonal.users.infrastructure.UserQueryRepositoryImplementation;

@Service
@AllArgsConstructor
public class ValidateTokenUseCase {

    AuthenticationTokenProvider authenticationTokenProvider;
    UserQueryRepositoryImplementation userRepository;

    public UserQuery validateToken(String token) {

        final Login login = authenticationTokenProvider.validateToken(token);

        final UserQuery user = userRepository.searchByEmail(login.value());

        return user;
    }
}
