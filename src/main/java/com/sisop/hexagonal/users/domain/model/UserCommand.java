package com.sisop.hexagonal.users.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommand {

    private String name;
    private String email;
    private String password;
    private Integer role;
    private String userId;
}
