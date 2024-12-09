package com.sisop.hexagonal.students.domain.model;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "VALUMNOS")
@NoArgsConstructor
public class StudentQuery {

    @Id
    @Column(name = "ID_USUARIO")
    private String id;

    @Column(name = "ID_INFPER")
    private String idPersonalInformation;

    @Column(name = "E_MAIL")
    private String email;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "A_PATERNO")
    private String lastName;

    @Column(name = "A_MATERNO")
    private String secondLastName;

    @Column(name = "SEXO")
    private String gender;

    @Column(name = "RFC")
    private String rfc;

    @Column(name = "CURP")
    private String curp;

}
