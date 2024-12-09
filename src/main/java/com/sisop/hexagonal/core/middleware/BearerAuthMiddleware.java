package com.sisop.hexagonal.core.middleware;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.sisop.hexagonal.auth.application.validate.ValidateTokenUseCase;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BearerAuthMiddleware extends OncePerRequestFilter{

    private final ValidateTokenUseCase authenticationTokenValidator;

    @Override
    protected void doFilterInternal(
            final HttpServletRequest httpServletRequest,
            final HttpServletResponse httpServletResponse,
            final FilterChain filterChain)
            throws ServletException, IOException, SignatureVerificationException {

        final String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null) {
            final String[] authElements = header.split(" ");

            if (authElements.length == 2 && "Bearer".equals(authElements[0])) {
                try {
                    final UserQuery user = authenticationTokenValidator.validateToken(authElements[1]);
                    SecurityContextHolder.getContext()
                            .setAuthentication(
                                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()));
                } catch (final RuntimeException e) {
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
