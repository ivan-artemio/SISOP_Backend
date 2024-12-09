package com.sisop.hexagonal.application.Infrastructure;

import com.sisop.hexagonal.application.Infrastructure.outbound.database.ApplicationQueryOracleRepository;
import com.sisop.hexagonal.application.domain.model.ApplicationCommand;
import com.sisop.hexagonal.application.domain.model.ApplicationQuery;
import com.sisop.hexagonal.application.domain.repository.ApplicationQueryRepository;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ApplicationQueryRepositoryImplementation implements ApplicationQueryRepository {

    private final ApplicationQueryOracleRepository applicationQueryOracleRepository;

    @Override
    public List<ApplicationQuery> findByUserId(String id) {
        return applicationQueryOracleRepository.findByUserId(id);
    }

    @Override
    public List<ApplicationQuery> findAll() {
        return applicationQueryOracleRepository.findAll();
    }

    public Optional<ApplicationQuery> findById(Long id) {
        return applicationQueryOracleRepository.findById(id);
    }

    @Override
    public Optional<ApplicationQuery> create(ApplicationCommand applicationCommand) {

        ApplicationQuery applicationQuery = new ApplicationQuery();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserQuery user = (UserQuery) auth.getPrincipal();

        applicationQuery.setUserId(user.getUserId());
        applicationQuery.setUbc(applicationCommand.getUbc());
        applicationQuery.setProjectId(applicationCommand.getProjectId());
        applicationQuery.setStatusId(1);
        applicationQuery.setDate(new Date());

        return Optional.of(applicationQueryOracleRepository.save(applicationQuery));
    }

    @Override
    public Optional<ApplicationQuery> update(Long id, ApplicationCommand applicationCommand) {

        ApplicationQuery applicationQuery = applicationQueryOracleRepository.findById(id).orElseThrow();

        applicationQuery.setUserId(applicationCommand.getUserId());
        applicationQuery.setUbc(applicationCommand.getUbc());
        applicationQuery.setProjectId(applicationCommand.getProjectId());

        return Optional.of(applicationQueryOracleRepository.save(applicationQuery));
    }

}
