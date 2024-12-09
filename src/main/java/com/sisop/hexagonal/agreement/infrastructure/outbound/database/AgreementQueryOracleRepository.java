package com.sisop.hexagonal.agreement.infrastructure.outbound.database;

import com.sisop.hexagonal.agreement.domain.model.AgreementQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgreementQueryOracleRepository extends JpaRepository<AgreementQuery, Long>{
    @Query("SELECT a FROM AgreementQuery a WHERE a.idOrganization = :id")
    List<AgreementQuery> findByIdOrganization(Long id);
}
