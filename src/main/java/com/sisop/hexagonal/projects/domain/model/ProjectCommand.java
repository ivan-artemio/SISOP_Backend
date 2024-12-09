package com.sisop.hexagonal.projects.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ProjectCommand {

    @NotEmpty(message = "El área es requerido.")
    private String areaId;

    @NotEmpty(message = "El nombre es requerido.")
    private String name;

    @NotEmpty(message = "El encargado es requerido.")
    private String responsible;

    @NotEmpty(message = "El tipo es requerido.")
    private String typeId;

    @NotNull(message = "La cuota es requerida.")
    @Min(value = 1, message = "La cuota debe ser mayor a 0.")
    private Integer quota;

    @NotEmpty(message = "La ciudad es requerida.")
    private String cityId;

    @NotEmpty(message = "El estatus es requerido.")
    private String status;

    @JsonFormat(pattern="yyyy-MM-dd", timezone = "America/Cancun")
    private Date cancellation;
}
