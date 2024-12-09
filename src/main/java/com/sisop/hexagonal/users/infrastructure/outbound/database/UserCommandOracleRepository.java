package com.sisop.hexagonal.users.infrastructure.outbound.database;

import com.sisop.hexagonal.users.domain.model.UserQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserCommandOracleRepository extends JpaRepository<UserQuery, Long> {}
