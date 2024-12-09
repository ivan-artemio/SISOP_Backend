package com.sisop.hexagonal.agreement.infrastructure;

import com.sisop.hexagonal.agreement.domain.model.AgreementQuery;
import com.sisop.hexagonal.agreement.domain.model.AgreementCommand;
import com.sisop.hexagonal.agreement.domain.repository.AgreementQueryRepository;
import com.sisop.hexagonal.agreement.infrastructure.outbound.database.AgreementQueryOracleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AgreementQueryRepositoryImplementation implements AgreementQueryRepository {

    private final AgreementQueryOracleRepository agreementQueryOracleRepository;

    @Override
    public Optional<AgreementQuery> findById(Long id) {
        return Optional.of(agreementQueryOracleRepository.findById(id).orElseThrow());
    }

    @Override
    public List<AgreementQuery> findByIdOrganization(Long id) {
        return agreementQueryOracleRepository.findByIdOrganization(id);
    }

    @Override
    public Optional<AgreementQuery> create(AgreementCommand agreementCommand) {

        AgreementQuery agreementQuery = new AgreementQuery();

        agreementQuery.setIdOrganization(agreementCommand.getIdOrganization());
        agreementQuery.setAgreementDate(agreementCommand.getAgreementDate());
        agreementQuery.setStatus(agreementCommand.getStatus());
        agreementQuery.setAgreementNumber(agreementCommand.getAgreementNumber());

        return Optional.of(agreementQueryOracleRepository.save(agreementQuery));
    }

    @Override
    public Optional<AgreementQuery> update(Long id, AgreementCommand agreementCommand) {

        AgreementQuery agreementQuery = agreementQueryOracleRepository.findById(id).orElseThrow();

        agreementQuery.setIdOrganization(agreementCommand.getIdOrganization());
        agreementQuery.setAgreementDate(agreementCommand.getAgreementDate());
        agreementQuery.setStatus(agreementCommand.getStatus());
        agreementQuery.setAgreementNumber(agreementCommand.getAgreementNumber());

        return Optional.of(agreementQueryOracleRepository.save(agreementQuery));
    }

    @Override
    public void delete(Long id) {
        agreementQueryOracleRepository.deleteById(id);
    }
}
