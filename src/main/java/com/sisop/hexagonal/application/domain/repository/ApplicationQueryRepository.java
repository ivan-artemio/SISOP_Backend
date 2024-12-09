package com.sisop.hexagonal.application.domain.repository;

import com.sisop.hexagonal.application.domain.model.ApplicationQuery;
import com.sisop.hexagonal.application.domain.model.ApplicationCommand;

import java.util.List;
import java.util.Optional;
public interface ApplicationQueryRepository {
    List<ApplicationQuery> findAll();
    List<ApplicationQuery> findByUserId(String userId);
    Optional<ApplicationQuery> findById(Long id);
    Optional<ApplicationQuery> create(ApplicationCommand applicationCommand);
    Optional<ApplicationQuery> update(Long userId, ApplicationCommand applicationCommand);
}
