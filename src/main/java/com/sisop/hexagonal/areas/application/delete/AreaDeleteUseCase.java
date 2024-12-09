package com.sisop.hexagonal.areas.application.delete;

import com.sisop.hexagonal.areas.domain.repository.AreaQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AreaDeleteUseCase {
    private final AreaQueryRepository areaQueryRepository;

    public void delete(Long id) {
        this.areaQueryRepository.delete(id);
    }
}
