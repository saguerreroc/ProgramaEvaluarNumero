package com.redeban.primos.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Clase que representa el objeto que contiene el número a evaluar si es primo o no.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestNumeroPrimoDTO implements Serializable {
    @NotEmpty(message = "El número no puede estar vacío")
    @Size(min = 1, max = 10, message = "El número debe tener entre 1 y 10 dígitos")
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "El número debe ser un entero positivo sin ceros a la izquierda ni caracteres no numéricos"
    )
    private String numero;
}
