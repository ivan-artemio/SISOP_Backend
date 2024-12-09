package com.sisop.hexagonal.users.domain.repository;

import com.sisop.hexagonal.users.domain.model.UserQuery;
import com.sisop.hexagonal.users.domain.model.UserCommand;

import java.util.Optional;

public interface UserCommandRepository {
    Optional<UserQuery> createUser(UserQuery userQuery);
    Optional<UserQuery> updateUser(Long id, UserQuery userQuery);
    void deleteUser(Long id);
}
