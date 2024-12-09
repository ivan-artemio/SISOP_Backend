package com.sisop.hexagonal.projects.infrastructure;

import com.sisop.hexagonal.projects.domain.model.ProjectCommand;
import com.sisop.hexagonal.projects.domain.model.ProjectQuery;
import com.sisop.hexagonal.projects.domain.repository.ProjectQueryRepository;
import com.sisop.hexagonal.projects.infrastructure.outbound.database.ProjectQueryOracleRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectQueryRepositoryImplementation implements ProjectQueryRepository {

    private final ProjectQueryOracleRepository projectQueryOracleRepository;

    @Override
    public Optional<ProjectQuery> findById(Long id) {
        return Optional.ofNullable(projectQueryOracleRepository.findProjectById(id));
    }

    @Override
    public List<ProjectQuery> findAll() {
        return projectQueryOracleRepository.findAllProjects();
    }

    @Override
    public Optional<ProjectQuery> create(ProjectCommand projectCommand) {
        ProjectQuery projectQuery = new ProjectQuery();
        return getProjectQuery(projectCommand, projectQuery);
    }

    @Override
    public Optional<ProjectQuery> update(Long id, ProjectCommand projectCommand) {
        ProjectQuery projectQuery = projectQueryOracleRepository.findProjectById(id);
        return getProjectQuery(projectCommand, projectQuery);
    }

    @Override
    public void delete(Long id) {
        projectQueryOracleRepository.deleteById(id);
    }

    private Optional<ProjectQuery> getProjectQuery(ProjectCommand projectCommand, ProjectQuery projectQuery) {

        projectQuery.setAreaId(projectCommand.getAreaId());
        projectQuery.setName(projectCommand.getName());
        projectQuery.setResponsible(projectCommand.getResponsible());
        projectQuery.setTypeId(projectCommand.getTypeId());
        projectQuery.setQuota(projectCommand.getQuota());
        projectQuery.setCityId(projectCommand.getCityId());
        projectQuery.setStatus(projectCommand.getStatus());
        projectQuery.setCancellation(projectCommand.getCancellation());

        return Optional.of(projectQueryOracleRepository.save(projectQuery));
    }
}
