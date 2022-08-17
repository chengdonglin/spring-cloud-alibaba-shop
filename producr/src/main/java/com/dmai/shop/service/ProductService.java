package com.dmai.shop.service;

import com.dmai.shop.bean.Product;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 11:52:58
 */
public interface ProductService {

    /**
     * 根据商品id获取商品信息
     * @param pid
     * @return
     */
    Product getProductById(Long pid);

    /**
     * 扣减库存
     * @param count
     * @param id
     * @return
     */
    Integer updateProductStockById(Integer count,Long id);
}
