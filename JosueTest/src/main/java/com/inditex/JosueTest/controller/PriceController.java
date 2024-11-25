package com.inditex.JosueTest.controller;

import com.inditex.JosueTest.model.response.PriceResponse;
import com.inditex.JosueTest.service.GetPriceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/v1/prices")
@AllArgsConstructor
public class PriceController {

    @Autowired
    GetPriceService priceService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/getProductPrice",
            produces = { "application/json"}
    )

    public ResponseEntity<PriceResponse> getProductPrice(@RequestParam(name = "date") LocalDateTime date,
                                                         @RequestParam(name = "id") Long productId,
                                                         @RequestParam(name = "brand") Long brandId ){
        PriceResponse response = priceService.getProductPrice(date,productId,brandId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
