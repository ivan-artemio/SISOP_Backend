package com.sisop.hexagonal.areas.domain.model;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CL_AREASERVICIO")
@NoArgsConstructor
public class AreaQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_generator")
    @SequenceGenerator(name = "area_generator", sequenceName = "SAE.ID_AREA", allocationSize = 1)
    @Column(name = "ID_AREA")
    private Long id;

    @Column(name = "NM_AREA")
    private String name;

    @Column(name = "ID_DEPENDENCIA")
    private String idOrganization;

    @Column(name = "TELEFONO")
    private String phone;

    @Column(name = "NM_RESPONSABLE")
    private String responsible;
}
