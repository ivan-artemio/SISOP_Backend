package com.sisop.hexagonal.subjects.domain.model;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubjectCommand {
    private String idUser;
    private String name;
    private String description;
}
