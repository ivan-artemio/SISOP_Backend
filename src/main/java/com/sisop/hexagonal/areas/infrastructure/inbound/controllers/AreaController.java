package com.sisop.hexagonal.areas.infrastructure.inbound.controllers;

import com.sisop.hexagonal.areas.application.create.AreaCreateUseCase;
import com.sisop.hexagonal.areas.application.delete.AreaDeleteUseCase;
import com.sisop.hexagonal.areas.application.find.AreaFindUseCase;
import com.sisop.hexagonal.areas.application.update.AreaUpdateUseCase;
import com.sisop.hexagonal.areas.domain.model.AreaCommand;
import com.sisop.hexagonal.areas.domain.model.AreaQuery;
import com.sisop.hexagonal.core.payload.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaFindUseCase areaFindUseCase;
    private final AreaCreateUseCase areaCreateUseCase;
    private final AreaUpdateUseCase areaUpdateUseCase;
    private final AreaDeleteUseCase areaDeleteUseCase;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        AreaQuery area = this.areaFindUseCase.findById(id);

        if (area == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Area not found")
                            .success(false)
                            .errors(List.of("Area no encontrada."))
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Area found")
                        .success(true)
                        .data(area)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping("organization/{id}")
    public ResponseEntity findByOrganization(@PathVariable Long id) {

        List<AreaQuery> areas = this.areaFindUseCase.findByIdOrganization(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Areas found")
                        .success(true)
                        .data(areas)
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody AreaCommand areaCommand) {
        AreaQuery areaQuery = this.areaCreateUseCase.create(areaCommand);

        if (areaQuery == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Area not created")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Area created")
                        .success(true)
                        .data(areaQuery)
                        .build(), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody AreaCommand areaCommand) {
        AreaQuery area = this.areaUpdateUseCase.update(id, areaCommand);

        if (area == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Area not updated")
                            .success(false)
                            .build(), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Area updated")
                        .success(true)
                        .data(area)
                        .build(), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.areaDeleteUseCase.delete(id);
    }

}
