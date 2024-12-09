package com.sisop.hexagonal.projects.application.delete;

import com.sisop.hexagonal.projects.domain.model.ProjectCommand;
import com.sisop.hexagonal.projects.domain.model.ProjectQuery;
import com.sisop.hexagonal.projects.domain.repository.ProjectQueryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectDeleteUseCase {

    private final ProjectQueryRepository projectQueryRepository;

    public void delete(Long id) {
        this.projectQueryRepository.delete(id);
    }
}
