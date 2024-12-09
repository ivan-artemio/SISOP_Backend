package com.sisop.hexagonal.users.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TUSUARIOS")
@NoArgsConstructor
public class UserQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "ISEQ$$_348889", allocationSize = 1)
    @Column(name = "USUA_USUARIO")
    private Long id;

    @Column(name = "USUA_NOMBRE")
    private String name;

    @Column(name = "USUA_PASSWORD")
    private String password;

    @Column(name = "USUA_CORREO")
    private String email;

    @Column(name = "USUA_ROL")
    private Integer role;

    @Column(name = "ID_USUARIO")
    private String userId;

}
