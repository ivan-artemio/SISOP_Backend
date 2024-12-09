package com.sisop.hexagonal.areas.infrastructure.outbound.database;

import com.sisop.hexagonal.areas.domain.model.AreaQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AreaQueryOracleRepository extends JpaRepository<AreaQuery, Long> {
        @Query("SELECT a FROM AreaQuery a WHERE a.idOrganization = :id")
        List<AreaQuery> findByIdOrganization(Long id);
}