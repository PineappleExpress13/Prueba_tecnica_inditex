package com.inditex.service;



import com.inditex.JosueTest.mapper.PriceMapper;
import com.inditex.JosueTest.model.entity.Price;
import com.inditex.JosueTest.model.response.PriceResponse;
import com.inditex.JosueTest.repository.PriceRepository;
import com.inditex.JosueTest.service.GetPriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = {GetPriceServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class GetPriveServiceImplTest {
    @Autowired
    GetPriceServiceImpl service;

    @MockBean
    PriceRepository repository;

    @MockBean
    PriceMapper mapper;

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

        Price price = new Price();


        Mockito.when(repository.findByDateProductIdAndBrandId(ArgumentMatchers.any(),ArgumentMatchers.anyLong(),ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(List.of(price)));
        Mockito.when(mapper.priceEntityToPriceResponse(price)).thenReturn(response);
        PriceResponse responseService = service.getProductPrice(LocalDateTime.now(),1L,1L);
        Assertions.assertEquals(response,responseService);
    }

    @Test
    void testNotFound(){
        RuntimeException ex1 = Assertions.assertThrows( RuntimeException.class, () -> {
            service.getProductPrice(null,1L,1L);
        });

        Assertions.assertEquals(ex1.getMessage(),"PRICES-F-002");
    }
}
