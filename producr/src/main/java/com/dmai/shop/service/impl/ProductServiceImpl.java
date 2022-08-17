package com.dmai.shop.service.impl;

import com.dmai.shop.bean.Product;
import com.dmai.shop.mapper.ProductMapper;
import com.dmai.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 11:54:30
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(Long pid) {
        return productMapper.selectById(pid);
    }

    @Override
    public Integer updateProductStockById(Integer count, Long id) {
        return productMapper.updateProductStockById(count,id);
    }
}
