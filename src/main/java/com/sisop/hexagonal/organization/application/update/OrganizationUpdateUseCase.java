package com.sisop.hexagonal.organization.application.update;

import com.sisop.hexagonal.organization.domain.model.OrganizationCommand;
import com.sisop.hexagonal.organization.domain.model.OrganizationQuery;
import com.sisop.hexagonal.organization.domain.repository.OrganizationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationUpdateUseCase {

    private final OrganizationQueryRepository organizationQueryRepository;

    public OrganizationQuery update(Long id, OrganizationCommand organizationCommand){
        return this.organizationQueryRepository.update(id, organizationCommand).orElse(null);
    }

}
