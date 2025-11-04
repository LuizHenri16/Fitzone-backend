package com.fitzone.FITZONE.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException e) {
         return ResponseEntity
                 .status(HttpStatus.BAD_REQUEST)
                 .body(Map.of("error", e.getMessage()));

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String rootCauseMessage = ex.getMostSpecificCause().getMessage();

        if (rootCauseMessage != null && (rootCauseMessage.contains("UK_CPF_CUSTOMER") || rootCauseMessage.contains("cpf"))) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "CPF já cadastrado. Por favor, verifique o valor informado."));
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "Erro de violação ao cadastrar cpf"));
    }
}
