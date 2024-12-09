package com.sisop.hexagonal.agreement.application.find;

import com.sisop.hexagonal.agreement.domain.model.AgreementQuery;
import com.sisop.hexagonal.agreement.domain.repository.AgreementQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementFindUseCase {

    private final AgreementQueryRepository agreementQueryRepository;

    public AgreementQuery findById(Long id){
        return this.agreementQueryRepository.findById(id).orElse(null);
    }

    public List<AgreementQuery> findByIdOrganization(Long id){
        return this.agreementQueryRepository.findByIdOrganization(id);
    }
}
