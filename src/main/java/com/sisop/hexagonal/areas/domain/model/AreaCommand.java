package com.sisop.hexagonal.areas.domain.model;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Builder
public class AreaCommand {

    @NotEmpty(message = "El nombre es requerido.")
    private String name;

    @NotEmpty(message = "Es necesario indicar la organización.")
    private String idOrganization;

    @NotEmpty(message = "El teléfono es requerido.")
    private String phone;

    @NotEmpty(message = "El nombre del reponsable es requerido.")
    private String responsible;
}
