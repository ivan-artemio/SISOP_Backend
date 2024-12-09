package com.sisop.hexagonal.application.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ApplicationCommand {

    private String userId;

    @NotEmpty(message = "La materia es requerida.")
    private String ubc;

    private Date date;

    @NotNull(message = "El proyecto es requerido.")
    private Integer projectId;

    private Integer statusId;
    private Date authorizedDate;
    private String authorizedUser;

}
