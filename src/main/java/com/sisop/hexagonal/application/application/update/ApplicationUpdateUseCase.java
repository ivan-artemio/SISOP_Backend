package com.sisop.hexagonal.application.application.update;

import com.sisop.hexagonal.application.domain.model.ApplicationCommand;
import com.sisop.hexagonal.application.domain.model.ApplicationQuery;
import com.sisop.hexagonal.application.domain.repository.ApplicationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationUpdateUseCase {

    private final ApplicationQueryRepository applicationQueryRepository;

    public ApplicationQuery update(Long id, ApplicationCommand applicationCommand){
        return this.applicationQueryRepository.update(id, applicationCommand).orElse(null);
    }
}
