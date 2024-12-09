package com.sisop.hexagonal.organization.application.delete;

import com.sisop.hexagonal.organization.domain.repository.OrganizationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationDeleteUseCase {
    private final OrganizationQueryRepository organizationQueryRepository;

    public void delete(Long id) {
       this.organizationQueryRepository.delete(id);
    }
}
