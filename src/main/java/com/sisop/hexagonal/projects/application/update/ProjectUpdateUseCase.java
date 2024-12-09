package com.sisop.hexagonal.projects.application.update;

import com.sisop.hexagonal.projects.domain.model.ProjectQuery;
import com.sisop.hexagonal.projects.domain.model.ProjectCommand;
import com.sisop.hexagonal.projects.domain.repository.ProjectQueryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectUpdateUseCase {

    private final ProjectQueryRepository projectQueryRepository;

    public ProjectQuery update(Long id, ProjectCommand projectCommand){
        return this.projectQueryRepository.update(id, projectCommand).orElse(null);
    }
}
