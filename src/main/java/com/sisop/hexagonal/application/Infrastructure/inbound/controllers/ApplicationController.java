package com.sisop.hexagonal.application.Infrastructure.inbound.controllers;

import com.sisop.hexagonal.application.application.create.ApplicationCreateUseCase;
import com.sisop.hexagonal.application.application.find.ApplicationFindUseCase;
import com.sisop.hexagonal.application.application.update.ApplicationUpdateUseCase;
import com.sisop.hexagonal.application.domain.model.ApplicationCommand;
import com.sisop.hexagonal.application.domain.model.ApplicationQuery;
import com.sisop.hexagonal.core.payload.MessageResponse;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationFindUseCase applicationFindUseCase;
    private final ApplicationCreateUseCase applicationCreateUseCase;
    private final ApplicationUpdateUseCase applicationUpdateUseCase;

    @GetMapping
    public ResponseEntity findAll() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserQuery user = (UserQuery) auth.getPrincipal();
        List<ApplicationQuery> applications = null;

        if (user.getRole() == 1) {
            applications = this.applicationFindUseCase.findAll();
        } else {
            applications = this.applicationFindUseCase.findByUserId(user.getUserId());
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Applications found")
                        .success(true)
                        .data(applications)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity findId(@PathVariable Long id) {

        ApplicationQuery application = this.applicationFindUseCase.findById(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Application found")
                        .success(true)
                        .data(application)
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ApplicationCommand applicationCommand) {
        ApplicationQuery application = this.applicationCreateUseCase.create(applicationCommand);

        if (application == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Application not created")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Application created")
                        .success(true)
                        .data(application)
                        .build(), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody ApplicationCommand applicationCommand) {
        ApplicationQuery application = this.applicationUpdateUseCase.update(id, applicationCommand);

        if (application == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Application not updated")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Application updated")
                        .success(true)
                        .data(application)
                        .build(), HttpStatus.OK
        );
    }

}
