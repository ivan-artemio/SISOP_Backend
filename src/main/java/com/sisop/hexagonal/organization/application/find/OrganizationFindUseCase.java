package com.sisop.hexagonal.organization.application.find;

import com.sisop.hexagonal.organization.domain.model.OrganizationQuery;
import com.sisop.hexagonal.organization.domain.repository.OrganizationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationFindUseCase {

    private final OrganizationQueryRepository organizationQueryRepository;

    public OrganizationQuery findById(Long id){
        return this.organizationQueryRepository.findById(id).orElse(null);
    }
    public List<OrganizationQuery> findAll(){
        return this.organizationQueryRepository.findAll();
    }

    public OrganizationQuery searchBy(String searchType, String searchValue){
        return this.organizationQueryRepository.searchBy(searchType, searchValue).orElse(null);
    }
}
