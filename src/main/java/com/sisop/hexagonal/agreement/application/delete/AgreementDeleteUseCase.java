package com.sisop.hexagonal.agreement.application.delete;

import com.sisop.hexagonal.agreement.domain.repository.AgreementQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgreementDeleteUseCase {

    private final AgreementQueryRepository agreementQueryRepository;

    public void delete(Long id){
        this.agreementQueryRepository.delete(id);
    }
}
