package com.sisop.hexagonal.agreement.domain.repository;

import com.sisop.hexagonal.agreement.domain.model.AgreementQuery;
import com.sisop.hexagonal.agreement.domain.model.AgreementCommand;

import java.util.List;
import java.util.Optional;

public interface AgreementQueryRepository {
    Optional<AgreementQuery> findById(Long id);
    List<AgreementQuery> findByIdOrganization(Long id);
    Optional<AgreementQuery> create(AgreementCommand agreementCommand);
    Optional<AgreementQuery> update(Long id, AgreementCommand agreementCommand);
    void delete(Long id);
}
