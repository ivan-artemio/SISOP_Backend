package com.sisop.hexagonal.users.infrastructure.inbound.controllers;

import com.sisop.hexagonal.core.payload.MessageResponse;
import com.sisop.hexagonal.users.application.authenticate.UserAuthenticateUseCase;
import com.sisop.hexagonal.users.application.create.UserCreateUseCase;
import com.sisop.hexagonal.users.application.find.UserFindUseCase;
import com.sisop.hexagonal.users.domain.model.UserCommand;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFindUseCase userFindUseCase;
    private final UserCreateUseCase userCreateUseCase;
    private final UserAuthenticateUseCase userAuthenticateUseCase;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id)  {
        UserQuery user = this.userFindUseCase.findById(id);

        if (user == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("User not found")
                            .success(false)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("User found")
                        .success(true)
                        .data(user)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<UserQuery> users = this.userFindUseCase.findAll();

        if (users.isEmpty()) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Users not found")
                            .success(false)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Users found")
                        .success(true)
                        .data(users)
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserCommand UserCommand) {

        UserQuery user = this.userCreateUseCase.createUser(UserCommand);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("User registered")
                        .success(true)
                        .data(user)
                        .build(), HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserCommand userCommand) {

        String token = this.userAuthenticateUseCase.authenticateUser(userCommand);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("User authenticated")
                        .success(true)
                        .data(token)
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping("/info")
    public ResponseEntity information() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserQuery user = (UserQuery) auth.getPrincipal();

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("User found")
                        .success(true)
                        .data(
                                UserCommand.builder()
                                        .name(user.getName())
                                        .email(user.getEmail())
                                        .password("")
                                        .role(user.getRole())
                                        .userId(user.getUserId())
                                        .build()
                        )
                        .build(), HttpStatus.OK
        );
    }

    @RequestMapping("/microsoft/redirect")
    public void redirect(HttpServletResponse httpServletResponse) {
        String SSO_CLIENT_SECRET = "seso";
        String SSO_ENVIRONMENT = "N";
        String SSO_URL = "http://192.100.164.75:8083/login/faces/login.xhtml";

        String projectUrl = SSO_URL + "?destino=" + SSO_CLIENT_SECRET + "&local=" + SSO_ENVIRONMENT;

        httpServletResponse.setHeader("Location", projectUrl);
        httpServletResponse.setStatus(302);
    }

    @RequestMapping("/microsoft/callback")
    public void callback(HttpServletResponse httpServletResponse, @RequestParam Map<String, String> params ) throws UnsupportedEncodingException {
        String FRONTEND_URL = "http://localhost:4200/ms-auth";

        UserCommand userCommand = UserCommand.builder()
                .name(URLDecoder.decode(params.get("lusuario"), StandardCharsets.UTF_8))
                .email(params.get("log"))
                .password(params.get("token"))
                .role(2) // 2 is the role for students authenticated by Azure
                .build();

        UserQuery userFind = this.userFindUseCase.findByEmail(userCommand.getEmail());

        if (userFind == null)
            this.userCreateUseCase.createUser(userCommand);

        String token      = this.userAuthenticateUseCase.authenticateUserAzure(userCommand);
        String projectUrl = FRONTEND_URL + "?token=" + token;

        httpServletResponse.setHeader("Location", projectUrl);
        httpServletResponse.setStatus(302);
    }
}

