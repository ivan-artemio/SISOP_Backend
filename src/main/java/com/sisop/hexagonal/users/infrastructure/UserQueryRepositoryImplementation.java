package com.sisop.hexagonal.users.infrastructure;

import com.sisop.hexagonal.users.domain.model.UserQuery;
import com.sisop.hexagonal.users.domain.repository.UserQueryRepository;
import com.sisop.hexagonal.users.infrastructure.outbound.database.UserQueryOracleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImplementation implements UserQueryRepository {

    @Autowired
    private final UserQueryOracleRepository userQueryOracleRepository;

    @Override
    public Optional<UserQuery> findById(Long id) {
        return userQueryOracleRepository.findById(id);
    }

    @Override
    public List<UserQuery> findAll() {
        return userQueryOracleRepository.findAll();
    }

    @Override
    public UserQuery searchByEmail(String value) {
        return userQueryOracleRepository.findByEmail(value);
    }
}
