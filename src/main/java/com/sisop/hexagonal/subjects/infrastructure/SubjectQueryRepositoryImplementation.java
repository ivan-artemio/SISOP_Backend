package com.sisop.hexagonal.subjects.infrastructure;

import com.sisop.hexagonal.subjects.domain.model.SubjectQuery;
import com.sisop.hexagonal.subjects.domain.repository.SubjectQueryRepository;
import com.sisop.hexagonal.subjects.infrastructure.outbound.database.SubjectQueryOracleRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectQueryRepositoryImplementation implements SubjectQueryRepository {

    private final SubjectQueryOracleRepository subjectQueryOracleRepository;
    @Override
    public List<SubjectQuery> findById(String id) {
        return subjectQueryOracleRepository.findSubjectsByUserId(id);
    }

    @Override
    public List<SubjectQuery> findAll() {
        return subjectQueryOracleRepository.findAllSubjects();
    }

}