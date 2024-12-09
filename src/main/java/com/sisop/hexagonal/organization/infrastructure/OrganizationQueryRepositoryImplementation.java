package com.sisop.hexagonal.organization.infrastructure;

import com.sisop.hexagonal.organization.domain.model.OrganizationCommand;
import com.sisop.hexagonal.organization.domain.model.OrganizationQuery;
import com.sisop.hexagonal.organization.domain.repository.OrganizationQueryRepository;
import com.sisop.hexagonal.organization.infrastructure.outbound.database.OrganizationQueryOracleRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrganizationQueryRepositoryImplementation implements OrganizationQueryRepository {

    private final OrganizationQueryOracleRepository organizationQueryOracleRepository;

    @Override
    public Optional<OrganizationQuery> findById(Long id) {
        return organizationQueryOracleRepository.findById(id);
    }

    @Override
    public List<OrganizationQuery> findAll() {
        return organizationQueryOracleRepository.findAll();
    }

    @Override
    public Optional<OrganizationQuery> searchBy(String type, String value) {
        return Optional.ofNullable(organizationQueryOracleRepository.findBy(type, value));
    }

    @Override
    public Optional<OrganizationQuery> create(OrganizationCommand organizationCommand) {

        OrganizationQuery organizationQuery = new OrganizationQuery();

        return getOrganizationQuery(organizationCommand, organizationQuery);
    }

    @Override
    public Optional<OrganizationQuery> update(Long id, OrganizationCommand organizationCommand) {

        OrganizationQuery organizationQuery = organizationQueryOracleRepository.findById(id).orElseThrow();

        return getOrganizationQuery(organizationCommand, organizationQuery);
    }

    @Override
    public void delete(Long id) {
        this.organizationQueryOracleRepository.deleteById(id);
    }

    private Optional<OrganizationQuery> getOrganizationQuery(OrganizationCommand organizationCommand, OrganizationQuery organizationQuery) {
        organizationQuery.setName(organizationCommand.getName());
        organizationQuery.setAddress(organizationCommand.getAddress());
        organizationQuery.setPhone(organizationCommand.getPhone());
        organizationQuery.setAcronym(organizationCommand.getAcronym());
        organizationQuery.setResponsible(organizationCommand.getResponsible());
        organizationQuery.setRfc(organizationCommand.getRfc());

        return Optional.of(organizationQueryOracleRepository.save(organizationQuery));
    }
}
