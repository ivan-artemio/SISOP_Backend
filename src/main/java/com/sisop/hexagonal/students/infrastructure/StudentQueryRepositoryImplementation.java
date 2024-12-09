package com.sisop.hexagonal.students.infrastructure;

import com.sisop.hexagonal.students.domain.model.StudentQuery;
import com.sisop.hexagonal.students.domain.repository.StudentQueryRepository;
import com.sisop.hexagonal.students.infrastructure.outbound.database.StudentQueryOracleRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentQueryRepositoryImplementation implements StudentQueryRepository {

    private final StudentQueryOracleRepository studentQueryOracleRepository;

    @Override
    public Optional<StudentQuery> findById(String id) {
        return Optional.ofNullable(studentQueryOracleRepository.findStudentById(id));
    }

    @Override
    public List<StudentQuery> findAll() {
        return studentQueryOracleRepository.findAllStudents();
    }

}
