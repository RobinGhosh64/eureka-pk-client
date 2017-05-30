package com.sample.pkmst.services.impl;

import com.google.common.primitives.Longs;
import com.sample.pkmst.dao.IProductDao;
import com.sample.pkmst.dto.ProductDto;
import com.sample.pkmst.services.IProductService;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Ninod Pillai
 *
 */
public class ProductServiceImpl implements IProductService {

    private final IProductDao productDao;

    public ProductServiceImpl(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(ProductDto productVo) {
        productDao.save(productVo);
    }

    @Override
    public List<ProductDto> getProducts() {
        return productDao.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }

    @Override
    public List<ProductDto> getProductsByIds(long[] productIds) {
        return productDao.getProductsByIds(Longs.asList(productIds));
    }
    
    
}
