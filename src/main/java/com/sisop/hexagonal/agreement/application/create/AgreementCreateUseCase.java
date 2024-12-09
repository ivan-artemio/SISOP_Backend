package com.sisop.hexagonal.agreement.application.create;

import com.sisop.hexagonal.agreement.domain.model.AgreementCommand;
import com.sisop.hexagonal.agreement.domain.model.AgreementQuery;
import com.sisop.hexagonal.agreement.domain.repository.AgreementQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgreementCreateUseCase {

    private final AgreementQueryRepository agreementQueryRepository;

    public AgreementQuery create(AgreementCommand agreementCommand){
        return this.agreementQueryRepository.create(agreementCommand).orElse(null);
    }

}
