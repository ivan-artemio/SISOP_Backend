package com.sisop.hexagonal.application.domain.model;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TSOLICITUDES")
@NoArgsConstructor
public class ApplicationQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_generator")
    @SequenceGenerator(name = "application_generator", sequenceName = "ISEQ$$_360156", allocationSize = 1)
    @Column(name = "SOLI_SOLICTUD")
    private Long id;

    @Column(name = "SOLI_MATRICULA")
    private String userId;

    @Column(name = "SOLI_UBC")
    private String ubc;

    @Column(name = "SOLI_FECHA")
    private Date date;

    @Column(name = "SOLI_PROYECTO")
    private Integer projectId;

    @Column(name = "SOLI_ESTADO")
    private Integer statusId;

    @Column(name = "SOLI_FECHA_AUTORIZADO")
    private Date authorizedDate;

    @Column(name = "SOLI_USUARIO_AUTORIZADO")
    private String authorizedUser;

}
