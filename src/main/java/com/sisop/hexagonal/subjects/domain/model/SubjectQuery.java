package com.sisop.hexagonal.subjects.domain.model;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "VMATERIAS")
@NoArgsConstructor
public class SubjectQuery {
    @Id
    @Column(name = "ID_UBC")
    private String id;

    @Column(name = "ID_USUARIO")
    private String idUser;

    @Column(name = "NM_UBC")
    private String name;

    @Column(name = "DESCRIPCION")
    private String description;
}
