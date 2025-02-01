package com.redeban.primos.service;

import com.redeban.primos.dto.RequestNumeroPrimoDTO;
import com.redeban.primos.dto.ResponseNumeroPrimoDTO;
/**
 * Interfaz que define el contrato para evaluar si un número es primo o no.
 */
public interface INumeroPrimoService {
    /**
     * Método que evalúa si un número es primo o no.
     * @param requestNumeroPrimo Objeto que contiene el número a evaluar.
     * @return Objeto que contiene el número evaluado y si es primo o no.
     */
    ResponseNumeroPrimoDTO evaluarNumero(RequestNumeroPrimoDTO requestNumeroPrimo);
}
