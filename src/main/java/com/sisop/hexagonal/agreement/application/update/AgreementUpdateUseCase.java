package com.sisop.hexagonal.agreement.application.update;

import com.sisop.hexagonal.agreement.domain.model.AgreementCommand;
import com.sisop.hexagonal.agreement.domain.model.AgreementQuery;
import com.sisop.hexagonal.agreement.domain.repository.AgreementQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgreementUpdateUseCase {

    private final AgreementQueryRepository agreementQueryRepository;

    public AgreementQuery update(Long id, AgreementCommand agreementCommand){
        return this.agreementQueryRepository.update(id, agreementCommand).orElse(null);
    }
}
