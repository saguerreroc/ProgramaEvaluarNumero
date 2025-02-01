package com.redeban.primos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * DTO para respuestas de error personalizadas.
 */
@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String code;
    private HttpStatus codeHttp;
    private String message;
}
