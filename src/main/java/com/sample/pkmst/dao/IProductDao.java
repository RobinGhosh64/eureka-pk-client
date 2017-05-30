package com.sample.pkmst.dao;


import java.util.List;

import com.sample.pkmst.dto.ProductDto;

/**
 * Created by kranthi on 6/23/2016.
 */
public interface IProductDao {

    List<ProductDto> getProductsByIds(List<Long> productIds);

    List<ProductDto> findAll();

    void delete(long id);

    void save(ProductDto ProductDto);

}