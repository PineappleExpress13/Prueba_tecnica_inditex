package com.inditex.controller;

import com.inditex.JosueTest.controller.PriceController;
import com.inditex.JosueTest.exception.MissingParameterException;
import com.inditex.JosueTest.model.response.PriceResponse;
import com.inditex.JosueTest.repository.PriceRepository;
import com.inditex.JosueTest.service.GetPriceService;
import com.inditex.JosueTest.service.GetPriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ContextConfiguration(classes = {PriceController.class})
@ExtendWith(SpringExtension.class)
public class PriceControllerTest {

    @Autowired
    PriceController controller;

    @MockBean
    GetPriceServiceImpl service;

    @Test
    void testControllerOk(){
        PriceResponse response = new PriceResponse();

        response.setPrice(new BigDecimal("99.99"));
        response.setRate(1);
        response.setBrand(1L);
        response.setCurrency("EUR");
        response.setEndDate(LocalDateTime.now());
        response.setStartDate(LocalDateTime.now());
        response.setProduct(1L);

        ResponseEntity<PriceResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        Mockito.when(service.getProductPrice(ArgumentMatchers.any(),ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(response);
        ResponseEntity<PriceResponse> ResponseController = controller.getProductPrice(LocalDateTime.now(),1L,1L);
        Assertions.assertEquals(responseEntity,ResponseController);
    }


}
