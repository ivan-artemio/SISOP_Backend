package com.sisop.hexagonal.students.application.find;

import com.sisop.hexagonal.students.domain.model.StudentQuery;
import com.sisop.hexagonal.students.domain.repository.StudentQueryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentFindUseCase {

    private final StudentQueryRepository studentQueryRepository;

    public List<StudentQuery> findAll(){
        return this.studentQueryRepository.findAll();
    }

    public StudentQuery findById(String id){
        return this.studentQueryRepository.findById(id).orElseThrow();
    }

}
