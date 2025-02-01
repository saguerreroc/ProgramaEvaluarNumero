package com.redeban.primos.service;

import com.redeban.primos.dto.RequestNumeroPrimoDTO;
import com.redeban.primos.dto.ResponseNumeroPrimoDTO;
import com.redeban.primos.service.impl.INumeroPrimoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class INumeroPrimoServiceImplTest {

    @InjectMocks private INumeroPrimoServiceImpl numeroPrimoService;

    @Test
    @DisplayName("Test para verificar si un número es primo")
    void evaluarNumero() {
        RequestNumeroPrimoDTO request = new RequestNumeroPrimoDTO("17");
        ResponseNumeroPrimoDTO response = numeroPrimoService.evaluarNumero(request);
        Assertions.assertEquals(17, response.getNumero());
        Assertions.assertTrue(response.getEsPrimo());
        Assertions.assertNotNull(response.getMensaje());
    }
    @Test
    @DisplayName("Test para verificar si un número no es primo")
    void evaluarNumeroNoPrimo() {
        RequestNumeroPrimoDTO request = new RequestNumeroPrimoDTO("10");
        ResponseNumeroPrimoDTO response = numeroPrimoService.evaluarNumero(request);
        Assertions.assertEquals(10, response.getNumero());
        Assertions.assertFalse(response.getEsPrimo());
        Assertions.assertNotNull(response.getMensaje());
    }
    @Test
    @DisplayName("Test para verificar si un número es primo y ocurre excepcion porque excede el limite de un int en Java")
    void evaluarNumeroExcedeLimite() {
        RequestNumeroPrimoDTO request = new RequestNumeroPrimoDTO("8747483648");
        Assertions.assertThrows(Exception.class, () -> numeroPrimoService.evaluarNumero(request));
    }
}
