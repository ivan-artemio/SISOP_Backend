package com.sisop.hexagonal.projects.domain.model;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "CL_PROYECTOSERVICIO")
@NoArgsConstructor
public class ProjectQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator", sequenceName = "SAE.ID_PROYECTO", allocationSize = 1)
    @Column(name = "ID_PROYECTO")
    private Long id;

    @Column(name = "ID_AREA")
    private String areaId;

    @Column(name = "NM_AREA", insertable = false, updatable = false)
    private String areaName;

    @Column(name = "NM_PROYECTO")
    private String name;

    @Column(name = "NM_ENCARGADO")
    private String responsible;

    @Column(name = "ID_TIPO")
    private String typeId;

    @Column(name = "NM_TIPO", insertable = false, updatable = false)
    private String typeName;

    @Column(name = "CUPO_PROYECTO_PF")
    private Integer quota;

    @Column(name = "ID_CIUDAD")
    private String cityId;

    @Column(name = "NM_CIUDAD", insertable = false, updatable = false)
    private String cityName;

    @Column(name = "STATUS_PROYECTO")
    private String status;

    @Column(name = "FECHA_CANCELACION")
    private Date cancellation;

}
