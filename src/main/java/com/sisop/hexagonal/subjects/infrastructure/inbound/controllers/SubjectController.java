package com.sisop.hexagonal.subjects.infrastructure.inbound.controllers;

import com.sisop.hexagonal.core.payload.MessageResponse;
import com.sisop.hexagonal.subjects.application.find.SubjectFindUseCase;
import com.sisop.hexagonal.subjects.domain.model.SubjectQuery;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectFindUseCase subjectFindUseCase;

    @GetMapping
    public ResponseEntity findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserQuery user = (UserQuery) auth.getPrincipal();

        String userId = user.getUserId() != null ? user.getUserId() : "";
        List<SubjectQuery> subjects = this.subjectFindUseCase.findById(userId);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Subjects found")
                        .success(true)
                        .data(subjects)
                        .build(), HttpStatus.OK
        );
    }
}
