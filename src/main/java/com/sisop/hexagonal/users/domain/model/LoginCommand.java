package com.sisop.hexagonal.users.domain.model;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginCommand {
    private String email;
    private String password;
}
