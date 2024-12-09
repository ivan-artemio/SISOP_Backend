package com.sisop.hexagonal.students.infrastructure.inbound.controllers;

import com.sisop.hexagonal.core.payload.MessageResponse;
import com.sisop.hexagonal.students.application.find.StudentFindUseCase;
import com.sisop.hexagonal.students.domain.model.StudentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentFindUseCase studentFindUseCase;

    @GetMapping
    public ResponseEntity findAll() {

        List<StudentQuery> students = this.studentFindUseCase.findAll();

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Students found")
                        .success(true)
                        .data(students)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        StudentQuery student = this.studentFindUseCase.findById(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Student found")
                        .success(true)
                        .data(student)
                        .build(), HttpStatus.OK
        );
    }
}
