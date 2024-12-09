package com.sisop.hexagonal.organization.infrastructure.inbound.controllers;

import com.sisop.hexagonal.organization.application.create.OrganizationCreateUseCase;
import com.sisop.hexagonal.organization.application.delete.OrganizationDeleteUseCase;
import com.sisop.hexagonal.organization.application.find.OrganizationFindUseCase;
import com.sisop.hexagonal.organization.application.update.OrganizationUpdateUseCase;
import com.sisop.hexagonal.organization.domain.model.OrganizationCommand;
import com.sisop.hexagonal.organization.domain.model.OrganizationQuery;
import com.sisop.hexagonal.core.payload.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationFindUseCase organizationFindUseCase;
    private final OrganizationCreateUseCase organizationCreateUseCase;
    private final OrganizationDeleteUseCase organizationDeleteUseCase;
    private final OrganizationUpdateUseCase organizationUpdateUseCase;

    @GetMapping
    public ResponseEntity findAll() {

        List<OrganizationQuery> organizations = this.organizationFindUseCase.findAll();

        if (organizations.isEmpty()) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Organizations not found")
                            .success(false)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Organizations found")
                        .success(true)
                        .data(organizations)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        OrganizationQuery organization = this.organizationFindUseCase.findById(id);

        if (organization == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Organization not found")
                            .success(false)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Organization found")
                        .success(true)
                        .data(organization)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping("/search/{type}/{value}")
    public ResponseEntity searchByAcronym(@PathVariable String type, @PathVariable String value) {
        OrganizationQuery organization = this.organizationFindUseCase.searchBy(type, value);

        if (organization == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Organization not found")
                            .success(false)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Organization found")
                        .success(true)
                        .data(organization)
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody OrganizationCommand organizationCommand) {
        OrganizationQuery organization = this.organizationCreateUseCase.create(organizationCommand);

        if (organization == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Organization not created")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Organization created")
                        .success(true)
                        .data(organization)
                        .build(), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody OrganizationCommand organizationCommand) {
        OrganizationQuery organization = this.organizationUpdateUseCase.update(id, organizationCommand);

        if (organization == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Organization not updated")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Organization updated")
                        .success(true)
                        .data(organization)
                        .build(), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.organizationDeleteUseCase.delete(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Organization deleted")
                        .success(true)
                        .build(), HttpStatus.OK
        );
    }

}
