package com.sisop.hexagonal.projects.infrastructure.inbound.controllers;

import com.sisop.hexagonal.projects.application.create.ProjectCreateUseCase;
import com.sisop.hexagonal.projects.application.delete.ProjectDeleteUseCase;
import com.sisop.hexagonal.projects.application.find.ProjectFindUseCase;
import com.sisop.hexagonal.core.payload.MessageResponse;
import com.sisop.hexagonal.projects.application.update.ProjectUpdateUseCase;
import com.sisop.hexagonal.projects.domain.model.ProjectCommand;
import com.sisop.hexagonal.projects.domain.model.ProjectQuery;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFindUseCase projectFindUseCase;
    private final ProjectCreateUseCase projectCreateUseCase;
    private final ProjectUpdateUseCase projectUpdateUseCase;
    private final ProjectDeleteUseCase projectDeleteUseCase;

    @GetMapping
    public ResponseEntity findAll() {

        List<ProjectQuery> projects = this.projectFindUseCase.findAll();

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Projects found")
                        .success(true)
                        .data(projects)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        ProjectQuery project = this.projectFindUseCase.findById(id);

        if (project == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Project not found")
                            .success(false)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Project found")
                        .success(true)
                        .data(project)
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProjectCommand projectCommand) {
        ProjectQuery project = this.projectCreateUseCase.create(projectCommand);

        if (project == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Project not created")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Project created")
                        .success(true)
                        .data(project)
                        .build(), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody ProjectCommand projectCommand) {
        ProjectQuery project = this.projectUpdateUseCase.update(id, projectCommand);

        if (project == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Project not updated")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Project updated")
                        .success(true)
                        .data(project)
                        .build(), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.projectDeleteUseCase.delete(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Project deleted")
                        .success(true)
                        .build(), HttpStatus.OK
        );
    }

}
