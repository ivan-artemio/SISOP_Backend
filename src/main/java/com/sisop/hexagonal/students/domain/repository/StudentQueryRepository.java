package com.sisop.hexagonal.students.domain.repository;

import com.sisop.hexagonal.students.domain.model.StudentQuery;

import java.util.List;
import java.util.Optional;

public interface StudentQueryRepository {
    List<StudentQuery> findAll();
    Optional<StudentQuery> findById(String id);
}