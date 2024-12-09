package com.sisop.hexagonal.agreement.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Getter
@Builder
public class AgreementCommand {

    @NotEmpty(message = "Es necesario indicar la orgranización.")
    private String idOrganization;

    @NotNull(message = "La fecha de convenio es requerida.")
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "America/Cancun")
    private Date agreementDate;

    @NotEmpty(message = "El estatus es requerido.")
    private String status;

    @NotEmpty(message = "El número de convenio es requerido.")
    private String agreementNumber;
}
