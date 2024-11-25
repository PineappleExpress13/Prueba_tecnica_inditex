package com.inditex.JosueTest.service;

import com.inditex.JosueTest.model.response.PriceResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

public interface GetPriceService {


    /**
     * Get the product price based on the date and brandId
     *
     * @param date the date of the request
     * @param ProductId the product id
     * @param BrandId the brand id
     * */
    PriceResponse getProductPrice(LocalDateTime date,
                                  Long ProductId,
                                  Long BrandId);
}
