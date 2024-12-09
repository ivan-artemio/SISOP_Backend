package com.sisop.hexagonal.areas.application.find;


import com.sisop.hexagonal.areas.domain.model.AreaQuery;
import com.sisop.hexagonal.areas.domain.repository.AreaQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaFindUseCase {

    private final AreaQueryRepository areaQueryRepository;

    public AreaQuery findById(Long id){
        return this.areaQueryRepository.findById(id).orElse(null);
    }
    public List<AreaQuery> findAll(){
        return this.areaQueryRepository.findAll();
    }
    public List<AreaQuery> findByIdOrganization(Long id){
        return this.areaQueryRepository.findByIdOrganization(id);
    }
}
