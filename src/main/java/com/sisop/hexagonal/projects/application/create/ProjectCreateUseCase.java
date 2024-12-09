package com.sisop.hexagonal.projects.application.create;

import com.sisop.hexagonal.projects.domain.model.ProjectCommand;
import com.sisop.hexagonal.projects.domain.model.ProjectQuery;
import com.sisop.hexagonal.projects.domain.repository.ProjectQueryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCreateUseCase {

    private final ProjectQueryRepository projectQueryRepository;

    public ProjectQuery create(ProjectCommand projectCommand){
        return this.projectQueryRepository.create(projectCommand).orElse(null);
    }
}
