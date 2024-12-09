package com.sisop.hexagonal.core.exceptions;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sisop.hexagonal.core.payload.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.sentry.Sentry;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        Sentry.captureException(ex);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Validation error")
                        .success(false)
                        .errors(errors)
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        Sentry.captureException(ex);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message(ex.getMessage())
                        .success(false)
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(SignatureVerificationException.class)
    public ResponseEntity handleSignatureVerificationException(SignatureVerificationException ex) {
        Sentry.captureException(ex);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message(ex.getMessage())
                        .success(false)
                        .build(), HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException ex) {
        Sentry.captureException(ex);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message(ex.getMessage())
                        .success(false)
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity handleJWTVerificationException(JWTVerificationException ex) {
        Sentry.captureException(ex);
        
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message(ex.getMessage())
                        .success(false)
                        .build(), HttpStatus.UNAUTHORIZED
        );
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
