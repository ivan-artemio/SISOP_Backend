package com.sisop.hexagonal.users.infrastructure.outbound.database;

import com.sisop.hexagonal.users.domain.model.UserQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserQueryOracleRepository extends JpaRepository<UserQuery, Long> {

    String users = "SELECT * FROM TUSUARIOS u LEFT JOIN VALUMNOS v ON v.E_MAIL = u.USUA_CORREO";
    String userByEmail = users + " WHERE u.USUA_CORREO = ?1";

    @Query(value = userByEmail, nativeQuery = true)
    UserQuery findByEmail(String value);
}