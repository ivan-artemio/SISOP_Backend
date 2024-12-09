package com.sisop.hexagonal.users.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginMicrosoft {
    String log;
    String token;
    String id;
    String vig;
    String lusuario;
}
