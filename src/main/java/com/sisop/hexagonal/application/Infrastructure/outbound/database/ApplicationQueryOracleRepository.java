package com.sisop.hexagonal.application.Infrastructure.outbound.database;

import com.sisop.hexagonal.application.domain.model.ApplicationQuery;
import io.sentry.protocol.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationQueryOracleRepository extends JpaRepository<ApplicationQuery, Long>{
    @Query("SELECT a FROM ApplicationQuery a WHERE a.userId = :userId")
    List<ApplicationQuery> findByUserId(String userId);
}
