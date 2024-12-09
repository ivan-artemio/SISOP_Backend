package com.sisop.hexagonal.application.application.create;

import com.sisop.hexagonal.application.domain.model.ApplicationCommand;
import com.sisop.hexagonal.application.domain.model.ApplicationQuery;
import com.sisop.hexagonal.application.domain.repository.ApplicationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationCreateUseCase {

    private final ApplicationQueryRepository applicationQueryRepository;

    public ApplicationQuery create(ApplicationCommand applicationCommand){
        return this.applicationQueryRepository.create(applicationCommand).orElse(null);
    }

}
