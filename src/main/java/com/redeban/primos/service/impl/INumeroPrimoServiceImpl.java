package com.redeban.primos.service.impl;

import com.redeban.primos.dto.RequestNumeroPrimoDTO;
import com.redeban.primos.dto.ResponseNumeroPrimoDTO;
import com.redeban.primos.exception.ExcepcionNumeroPrimo;
import com.redeban.primos.service.INumeroPrimoService;
import com.redeban.primos.util.GeneralConstantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz NumeroPrimoService.
 */
@Slf4j
@Service
public class INumeroPrimoServiceImpl implements INumeroPrimoService {
    /**
     * Método que evalúa si un número es primo o no.
     *
     * @param requestNumeroPrimo Objeto que contiene el número a evaluar.
     * @return Objeto que contiene el número evaluado y si es primo o no.
     */
    @Override
    public ResponseNumeroPrimoDTO evaluarNumero(RequestNumeroPrimoDTO requestNumeroPrimo) {
        try {
            log.info("Inicia la evaluación del número: {}", requestNumeroPrimo.getNumero());
            int numero = Integer.parseInt(requestNumeroPrimo.getNumero());
            if (numero <= 1) {
                log.info("El número {} no es primo", numero);
                return new ResponseNumeroPrimoDTO(numero, false, String.format(GeneralConstantes.NUMERO_NO_PRIMO, numero));
            }
            if (numero == 2) {
                return new ResponseNumeroPrimoDTO(numero, true, String.format(GeneralConstantes.NUMERO_PRIMO, numero));
            }
            if (numero % 2 == 0) {
                log.info("El número {} no es primo", numero);
                return new ResponseNumeroPrimoDTO(numero, false, String.format(GeneralConstantes.NUMERO_NO_PRIMO, numero));
            }
            for (int i = 3; i <= Math.sqrt(numero); i += 2) {
                if (numero % i == 0) {
                    return new ResponseNumeroPrimoDTO(numero, false, String.format(GeneralConstantes.NUMERO_NO_PRIMO, numero));
                }
            }
            return new ResponseNumeroPrimoDTO(numero, true, String.format(GeneralConstantes.NUMERO_PRIMO, numero));
        } catch (NumberFormatException e) {
            log.error("Error al convertir el número: {}", requestNumeroPrimo.getNumero());
            throw new ExcepcionNumeroPrimo(GeneralConstantes.CODE_ERROR, HttpStatus.CONFLICT, GeneralConstantes.ERROR_CONVERTIR_NUMERO);
        }
    }
}
