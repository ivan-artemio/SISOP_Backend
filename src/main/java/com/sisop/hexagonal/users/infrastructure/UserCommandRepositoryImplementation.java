package com.sisop.hexagonal.users.infrastructure;

import com.sisop.hexagonal.users.domain.model.UserQuery;
import com.sisop.hexagonal.users.domain.repository.UserCommandRepository;
import com.sisop.hexagonal.users.infrastructure.outbound.database.UserCommandOracleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserCommandRepositoryImplementation implements UserCommandRepository {

    private final UserCommandOracleRepository userCommandOracleRepository;

    @Override
    public Optional<UserQuery> createUser(UserQuery userQuery) {
        return Optional.of(this.userCommandOracleRepository.save(userQuery));
    }

    @Override
    public Optional<UserQuery> updateUser(Long id, UserQuery userQuery) {
        return Optional.of(this.userCommandOracleRepository.save(userQuery));
    }

    @Override
    public void deleteUser(Long id) {
        this.userCommandOracleRepository.deleteById(id);
    }

}
