package com.sisop.hexagonal.agreement.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "CL_CONVENIO")
@NoArgsConstructor
public class AgreementQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agreement_generator")
    @SequenceGenerator(name = "agreement_generator", sequenceName = "SAE.ID_CONVENIO", allocationSize = 1)
    @Column(name = "ID_CONVENIO")
    private Long id;

    @Column(name = "ID_DEPENDENCIA")
    private String idOrganization;

    @Column(name = "FECHA_CONVENIO")
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "America/Cancun")
    private Date agreementDate;

    @Column(name = "STATUS_CONVENIO")
    private String status;

    @Column(name = "NUM_CONVENIO")
    private String agreementNumber;
}
