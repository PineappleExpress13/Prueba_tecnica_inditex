package com.inditex.JosueTest.service;

import com.inditex.JosueTest.exception.CustomInternalServerErrorException;
import com.inditex.JosueTest.exception.CustomNotFoundException;
import com.inditex.JosueTest.mapper.PriceMapper;
import com.inditex.JosueTest.model.entity.Price;
import com.inditex.JosueTest.model.response.PriceResponse;
import com.inditex.JosueTest.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GetPriceServiceImpl implements GetPriceService{

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    PriceMapper priceMapper;

    @Override
    public PriceResponse getProductPrice(LocalDateTime date,
                                         Long productId,
                                         Long brandId){
        PriceResponse response = new PriceResponse();
        Optional<List<Price>> pricesResult = Optional.empty();

        try{
            pricesResult = priceRepository.findByDateProductIdAndBrandId(date,productId,brandId);
        }catch (Exception e){
            throw new CustomInternalServerErrorException("PRICES-T-001");
        }


        if(pricesResult.isPresent() && !pricesResult.get().isEmpty()){
            List<Price> priceList = pricesResult.get();
            Price priorityPrice = priceList.stream().reduce((p1,p2) -> p1.getPriority() > p2.getPriority() ? p1 : p2).
                    orElse(null);
            response = priceMapper.priceEntityToPriceResponse(priorityPrice);
        }else{
            throw new CustomNotFoundException("PRICES-F-002");
        }

        return response;
    }
}
