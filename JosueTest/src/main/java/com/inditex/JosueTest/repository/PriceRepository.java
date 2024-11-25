package com.inditex.JosueTest.repository;

import com.inditex.JosueTest.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/** Interface for price repository*/
public interface PriceRepository extends JpaRepository<Price,Long> {

/**
 * Get a price for a product
 *
 * @param: date the date of the request
 * @param: productId the product id
 * @param: brandId the brand id
 * */

//@Query(value = "FROM Price  WHERE brandId = :brandId AND productId = :productId")
        @Query(value = "FROM Price  WHERE brandId = :brandId AND productId = :productId"
        + " AND :date BETWEEN startDate AND endDate")
        public Optional<List<Price>> findByDateProductIdAndBrandId(
        @Param("date") LocalDateTime date,
        @Param("productId") Long productId,
        @Param("brandId") Long brandId
        );

}
