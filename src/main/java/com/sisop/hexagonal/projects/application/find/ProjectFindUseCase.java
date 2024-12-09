package com.sisop.hexagonal.projects.application.find;

import com.sisop.hexagonal.projects.domain.model.ProjectQuery;
import com.sisop.hexagonal.projects.domain.repository.ProjectQueryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectFindUseCase {

    private final ProjectQueryRepository projectQueryRepository;

    public ProjectQuery findById(Long id){
        return this.projectQueryRepository.findById(id).orElse(null);
    }

    public List<ProjectQuery> findAll(){
        return this.projectQueryRepository.findAll();
    }

}
