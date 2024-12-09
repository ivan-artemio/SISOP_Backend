package com.sisop.hexagonal.organization.infrastructure.outbound.database;

import com.sisop.hexagonal.organization.domain.model.OrganizationQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrganizationQueryOracleRepository extends JpaRepository<OrganizationQuery, Long> {
    @Query("SELECT o FROM OrganizationQuery o WHERE ?1 = ?2")
    OrganizationQuery findBy(String type, String value);
}