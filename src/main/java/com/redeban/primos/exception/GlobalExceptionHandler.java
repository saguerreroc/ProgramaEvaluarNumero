package com.redeban.primos.exception;

import com.redeban.primos.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para capturar y devolver errores de validación.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Captura errores de validación y devuelve un JSON con los mensajes de error.
     *
     * @param ex Excepción lanzada por la validación de @Valid.
     * @return Un ResponseEntity con los errores de validación.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Extrae todos los errores de validación
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura la excepción ExcepcionNumeroPrimo y devuelve un ResponseEntity con el mensaje de error.
     *
     * @param ex Excepción personalizada ExcepcionNumeroPrimo.
     * @return Un ResponseEntity con el mensaje de error.
     */
    @ExceptionHandler(ExcepcionNumeroPrimo.class)
    public ResponseEntity<ErrorResponseDTO> handleExcepcionNumeroPrimo(ExcepcionNumeroPrimo ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                ex.getCode(),
                ex.getCodeHttp(),
                ex.getMessage()
        );
        return ResponseEntity.status(ex.getCodeHttp()).body(errorResponse);
    }
}
