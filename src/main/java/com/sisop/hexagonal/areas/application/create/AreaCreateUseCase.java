package com.sisop.hexagonal.areas.application.create;

import com.sisop.hexagonal.areas.domain.model.AreaCommand;
import com.sisop.hexagonal.areas.domain.model.AreaQuery;
import com.sisop.hexagonal.areas.domain.repository.AreaQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AreaCreateUseCase {

    private final AreaQueryRepository areaQueryRepository;

    public AreaQuery create(AreaCommand areaCommand){
        return this.areaQueryRepository.create(areaCommand).orElse(null);
    }
}
