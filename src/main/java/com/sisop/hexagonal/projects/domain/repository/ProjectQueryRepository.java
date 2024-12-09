package com.sisop.hexagonal.projects.domain.repository;

import com.sisop.hexagonal.projects.domain.model.ProjectCommand;
import com.sisop.hexagonal.projects.domain.model.ProjectQuery;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryRepository {
    List<ProjectQuery> findAll();
    Optional<ProjectQuery> findById(Long id);
    Optional<ProjectQuery> create(ProjectCommand projectCommand);
    Optional<ProjectQuery> update(Long id, ProjectCommand projectCommand);
    void delete(Long id);
}
