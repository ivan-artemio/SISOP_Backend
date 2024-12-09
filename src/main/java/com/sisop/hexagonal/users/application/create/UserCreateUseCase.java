package com.sisop.hexagonal.users.application.create;


import com.sisop.hexagonal.users.domain.model.UserCommand;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import com.sisop.hexagonal.users.domain.repository.UserCommandRepository;
import com.sisop.hexagonal.users.infrastructure.UserQueryRepositoryImplementation;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCreateUseCase {

    private final UserCommandRepository userCommandRepository;
    private final UserQueryRepositoryImplementation userQueryRepositoryImplementation;
    private final PasswordEncoder passwordEncoder;

    public UserQuery createUser(UserCommand userCommand){

        UserQuery user = this.userQueryRepositoryImplementation.searchByEmail(userCommand.getEmail());

        if (user != null) {
            throw new RuntimeException("User already exists");
        }

        UserQuery userQuery = new UserQuery();
        userQuery.setName(userCommand.getName());
        userQuery.setPassword(passwordEncoder.encode(userCommand.getPassword()));
        userQuery.setEmail(userCommand.getEmail());
        userQuery.setRole(userCommand.getRole());

        return this.userCommandRepository.createUser(userQuery).orElse(null);
    }
}
