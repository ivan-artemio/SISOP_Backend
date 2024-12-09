package com.sisop.hexagonal.areas.infrastructure;

import com.sisop.hexagonal.areas.domain.model.AreaCommand;
import com.sisop.hexagonal.areas.domain.model.AreaQuery;
import com.sisop.hexagonal.areas.domain.repository.AreaQueryRepository;
import com.sisop.hexagonal.areas.infrastructure.outbound.database.AreaQueryOracleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AreaQueryRepositoryImplementation implements AreaQueryRepository {

    private final AreaQueryOracleRepository areaQueryOracleRepository;

    @Override
    public Optional<AreaQuery> findById(Long id) {
        return areaQueryOracleRepository.findById(id);
    }

    @Override
    public List<AreaQuery> findAll() {
        return areaQueryOracleRepository.findAll();
    }

    @Override
    public List<AreaQuery> findByIdOrganization(Long id) {
        return areaQueryOracleRepository.findByIdOrganization(id);
    }

    @Override
    public Optional<AreaQuery> create(AreaCommand areaCommand) {

        AreaQuery areaQuery = new AreaQuery();

        areaQuery.setName(areaCommand.getName());
        areaQuery.setIdOrganization(areaCommand.getIdOrganization());
        areaQuery.setPhone(areaCommand.getPhone());
        areaQuery.setResponsible(areaCommand.getResponsible());

        return Optional.of(areaQueryOracleRepository.save(areaQuery));
    }

    @Override
    public Optional<AreaQuery> update(Long id, AreaCommand areaCommand) {

        AreaQuery areaQuery = areaQueryOracleRepository.findById(id).orElseThrow();

        areaQuery.setName(areaCommand.getName());
        areaQuery.setIdOrganization(areaCommand.getIdOrganization());
        areaQuery.setPhone(areaCommand.getPhone());
        areaQuery.setResponsible(areaCommand.getResponsible());

        return Optional.of(areaQueryOracleRepository.save(areaQuery));
    }

    @Override
    public void delete(Long id) {
        this.areaQueryOracleRepository.deleteById(id);
    }
}
