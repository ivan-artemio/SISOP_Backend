package com.sisop.hexagonal.users.application.authenticate;

import com.sisop.hexagonal.auth.application.create.CreateTokenUseCase;
import com.sisop.hexagonal.users.domain.model.UserCommand;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import com.sisop.hexagonal.users.infrastructure.UserQueryRepositoryImplementation;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserAuthenticateUseCase {

    private final UserQueryRepositoryImplementation userQueryRepositoryImplementation;
    private final CreateTokenUseCase createTokenUseCase;
    private final PasswordEncoder passwordEncoder;

    public String authenticateUser(UserCommand userCommand) {

        UserQuery user = this.userQueryRepositoryImplementation.searchByEmail(userCommand.getEmail());

        boolean match = passwordEncoder.matches(userCommand.getPassword(), user.getPassword());

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }

        return createTokenUseCase.createToken(userCommand.getEmail());
    }

    public String authenticateUserAzure(UserCommand userCommand) {

        UserQuery user = this.userQueryRepositoryImplementation.searchByEmail(userCommand.getEmail());

        if (user == null) {
            throw new RuntimeException("Invalid credentials");
        }

        return createTokenUseCase.createToken(userCommand.getEmail());
    }
}
