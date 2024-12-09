package com.sisop.hexagonal.students.domain.model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentCommand {

    @NotEmpty(message = "La matrícula es requerida.")
    private String id;

    @NotEmpty(message = "La información personal es requerida.")
    private String idPersonalInformation;

    private String email;

    private String name;

    private String lastName;

    private String secondLastName;

    private String gender;

    private String rfc;

    private String curp;
}
