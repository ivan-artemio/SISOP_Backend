package com.sisop.hexagonal.users.domain.repository;

import com.sisop.hexagonal.users.domain.model.UserQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryRepository {
    Optional<UserQuery> findById(Long id);
    List<UserQuery> findAll();

    UserQuery searchByEmail(String value);
}
