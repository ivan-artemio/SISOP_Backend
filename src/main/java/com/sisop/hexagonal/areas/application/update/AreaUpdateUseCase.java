package com.sisop.hexagonal.areas.application.update;

import com.sisop.hexagonal.areas.domain.model.AreaCommand;
import com.sisop.hexagonal.areas.domain.model.AreaQuery;
import com.sisop.hexagonal.areas.domain.repository.AreaQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AreaUpdateUseCase {
    private final AreaQueryRepository areaQueryRepository;

    public AreaQuery update(Long id, AreaCommand areaCommand){
        return this.areaQueryRepository.update(id, areaCommand).orElse(null);
    }
}
