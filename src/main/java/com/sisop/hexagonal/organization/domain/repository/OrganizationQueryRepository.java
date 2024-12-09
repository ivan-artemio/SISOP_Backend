package com.sisop.hexagonal.organization.domain.repository;

import com.sisop.hexagonal.organization.domain.model.OrganizationCommand;
import com.sisop.hexagonal.organization.domain.model.OrganizationQuery;

import java.util.List;
import java.util.Optional;

public interface OrganizationQueryRepository {
    Optional<OrganizationQuery> findById(Long id);
    List<OrganizationQuery> findAll();
    Optional<OrganizationQuery> searchBy(String type, String value);
    Optional<OrganizationQuery> create(OrganizationCommand organizationCommand);
    Optional<OrganizationQuery> update(Long id, OrganizationCommand organizationCommand);
    void delete(Long id);
}
