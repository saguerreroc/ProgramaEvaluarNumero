package com.redeban.primos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase que representa la respuesta de la evaluación de un número primo.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseNumeroPrimoDTO {
    private Integer numero;
    private Boolean esPrimo;
    private String mensaje;
}
