package com.sisop.hexagonal.agreement.infrastructure.inbound.controllers;

import com.sisop.hexagonal.agreement.application.create.AgreementCreateUseCase;
import com.sisop.hexagonal.agreement.application.delete.AgreementDeleteUseCase;
import com.sisop.hexagonal.agreement.application.find.AgreementFindUseCase;
import com.sisop.hexagonal.agreement.application.update.AgreementUpdateUseCase;
import com.sisop.hexagonal.agreement.domain.model.AgreementCommand;
import com.sisop.hexagonal.agreement.domain.model.AgreementQuery;
import com.sisop.hexagonal.core.payload.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementFindUseCase agreementFindUseCase;
    private final AgreementCreateUseCase agreementCreateUseCase;
    private final AgreementUpdateUseCase agreementUpdateUseCase;
    private final AgreementDeleteUseCase agreementDeleteUseCase;

    @GetMapping("/organization/{id}")
    public ResponseEntity findByOrganization(@PathVariable Long id) {
        List<AgreementQuery> agreements = this.agreementFindUseCase.findByIdOrganization(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Agreements found")
                        .success(true)
                        .data(agreements)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        AgreementQuery agreement = this.agreementFindUseCase.findById(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Agreement found")
                        .success(true)
                        .data(agreement)
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody AgreementCommand agreementCommand) {
        AgreementQuery agreement = this.agreementCreateUseCase.create(agreementCommand);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Agreement created")
                        .success(true)
                        .data(agreement)
                        .build(), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody AgreementCommand agreementCommand) {
        AgreementQuery agreement = this.agreementUpdateUseCase.update(id, agreementCommand);

        if (agreement == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Agreement not updated")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Agreement updated")
                        .success(true)
                        .data(agreement)
                        .build(), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.agreementDeleteUseCase.delete(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Agreement deleted")
                        .success(true)
                        .build(), HttpStatus.OK
        );
    }

}
