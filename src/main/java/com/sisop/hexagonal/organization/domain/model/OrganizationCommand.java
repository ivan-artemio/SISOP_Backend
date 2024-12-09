package com.sisop.hexagonal.organization.domain.model;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrganizationCommand {

    @NotEmpty(message = "El RFC es requerido.")
    private String rfc;

    @NotEmpty(message = "El nombre es requerido.")
    private String name;

    @NotEmpty(message = "El responsable es requerido.")
    private String responsible;

    @NotEmpty(message = "La diracción es requerido.")
    private String address;

    @NotEmpty(message = "El telefono es requerido.")
    private String phone;

    private String acronym;

}
