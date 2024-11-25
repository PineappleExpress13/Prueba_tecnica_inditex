package com.inditex.JosueTest.mapper;

import com.inditex.JosueTest.model.entity.Price;
import com.inditex.JosueTest.model.response.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PriceMapper {


    @Mapping(target = "product", source ="price.productId")
    @Mapping(target = "brand", source ="price.brandId")
    @Mapping(target = "rate", source ="price.priceList")
    @Mapping(target = "startDate", source ="price.startDate")
    @Mapping(target = "endDate", source ="price.endDate")
    @Mapping(target = "price", source ="price.price")
    @Mapping(target = "currency", source ="price.curr")
    PriceResponse priceEntityToPriceResponse(Price price);
}
