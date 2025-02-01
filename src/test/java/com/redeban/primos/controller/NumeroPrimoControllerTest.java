package com.redeban.primos.controller;

import com.redeban.primos.dto.RequestNumeroPrimoDTO;
import com.redeban.primos.dto.ResponseNumeroPrimoDTO;
import com.redeban.primos.service.INumeroPrimoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ExtendWith(MockitoExtension.class)
public class NumeroPrimoControllerTest {

    @InjectMocks private NumeroPrimoController numeroPrimoController;
    @Mock private INumeroPrimoService iNumeroPrimoService;

    @Test
    @DisplayName("Test para verificar si un número es primo")
    void evaluarNumero() {
        RequestNumeroPrimoDTO request = new RequestNumeroPrimoDTO("17");
        ResponseNumeroPrimoDTO response = new ResponseNumeroPrimoDTO(17, true, "El número 17 es primo");
        Mockito.when(iNumeroPrimoService.evaluarNumero(Mockito.any())).thenReturn(response);
        ResponseEntity<ResponseNumeroPrimoDTO> responseMethod = numeroPrimoController.evaluarNumero(request);
        Assertions.assertEquals(response, responseMethod.getBody());
        Mockito.verify(iNumeroPrimoService, Mockito.times(1)).evaluarNumero(Mockito.any());
    }
}
