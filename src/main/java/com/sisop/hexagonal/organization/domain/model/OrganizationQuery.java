package com.sisop.hexagonal.organization.domain.model;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cl_dependencias")
@NoArgsConstructor
public class OrganizationQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_generator")
    @SequenceGenerator(name = "organization_generator", sequenceName = "SAE.ID_DEPENDENCIA", allocationSize = 1)
    @Column(name = "ID_DEPENDENCIA")
    private Long id;

    @Column(name = "RFC")
    private String rfc;

    @Column(name = "NM_DEPENDENCIA")
    private String name;

    @Column(name = "NM_RESPONSABLE")
    private String responsible;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "TELEFONO")
    private String phone;

    @Column(name = "SIGLAS")
    private String acronym;
}
