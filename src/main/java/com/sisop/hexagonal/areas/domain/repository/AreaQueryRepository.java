package com.sisop.hexagonal.areas.domain.repository;

import com.sisop.hexagonal.areas.domain.model.AreaQuery;
import com.sisop.hexagonal.areas.domain.model.AreaCommand;

import java.util.List;
import java.util.Optional;

public interface AreaQueryRepository {
    Optional<AreaQuery> findById(Long id);
    List<AreaQuery> findAll();
    List<AreaQuery> findByIdOrganization(Long id);
    Optional<AreaQuery> create(AreaCommand areaCommand);
    Optional<AreaQuery> update(Long id, AreaCommand areaCommand);
    void delete(Long id);
}
