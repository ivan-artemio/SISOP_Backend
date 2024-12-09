package com.sisop.hexagonal.application.application.find;

import com.sisop.hexagonal.application.domain.model.ApplicationQuery;
import com.sisop.hexagonal.application.domain.repository.ApplicationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationFindUseCase {

    private final ApplicationQueryRepository applicationQueryRepository;

    public List<ApplicationQuery> findAll(){
        return this.applicationQueryRepository.findAll();
    }

    public ApplicationQuery findById(Long id){
        return this.applicationQueryRepository.findById(id).orElse(null);
    }

    public List<ApplicationQuery> findByUserId(String id){
        return this.applicationQueryRepository.findByUserId(id);
    }

}
