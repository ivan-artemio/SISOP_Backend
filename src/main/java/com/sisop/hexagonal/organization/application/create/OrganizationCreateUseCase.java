package com.sisop.hexagonal.organization.application.create;

import com.sisop.hexagonal.organization.domain.model.OrganizationCommand;
import com.sisop.hexagonal.organization.domain.model.OrganizationQuery;
import com.sisop.hexagonal.organization.domain.repository.OrganizationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationCreateUseCase {

    private final OrganizationQueryRepository organizationQueryRepository;

    public OrganizationQuery create(OrganizationCommand organizationCommand){
        return this.organizationQueryRepository.create(organizationCommand).orElse(null);
    }

}
