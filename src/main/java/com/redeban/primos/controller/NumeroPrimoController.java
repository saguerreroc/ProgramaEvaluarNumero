package com.redeban.primos.controller;

import com.redeban.primos.dto.RequestNumeroPrimoDTO;
import com.redeban.primos.dto.ResponseNumeroPrimoDTO;
import com.redeban.primos.service.INumeroPrimoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que expone los servicios para evaluar si un número es primo o no.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/numeroprimo")
@Slf4j
@Validated
public class NumeroPrimoController {

    private final INumeroPrimoService inumeroPrimoService;

    /**
     * Método que recibe un número y evalúa si es primo o no.
     *
     * @param request Objeto que contiene el número a evaluar.
     * @return Objeto que contiene el número evaluado y si es primo o no.
     */
    @PostMapping(value = "/evaluar")
    public ResponseEntity<ResponseNumeroPrimoDTO> evaluarNumero(@RequestBody @Valid RequestNumeroPrimoDTO request) {
        log.info("Controller - Request: {}", request.toString());
        return ResponseEntity.ok(inumeroPrimoService.evaluarNumero(request));
    }
}
