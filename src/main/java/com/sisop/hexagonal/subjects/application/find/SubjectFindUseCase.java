package com.sisop.hexagonal.subjects.application.find;

import com.sisop.hexagonal.subjects.domain.model.SubjectQuery;
import com.sisop.hexagonal.subjects.domain.repository.SubjectQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectFindUseCase {

    private final SubjectQueryRepository subjectQueryRepository;

    public List<SubjectQuery> findAll() {
        return this.subjectQueryRepository.findAll();
    }

    public List<SubjectQuery> findById(String id) {
        return this.subjectQueryRepository.findById(id);
    }
}
