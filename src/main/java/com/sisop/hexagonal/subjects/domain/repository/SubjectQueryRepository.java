package com.sisop.hexagonal.subjects.domain.repository;

import com.sisop.hexagonal.subjects.domain.model.SubjectQuery;

import java.util.List;

public interface SubjectQueryRepository {
    List<SubjectQuery> findAll();
    List<SubjectQuery> findById(String id);
}
