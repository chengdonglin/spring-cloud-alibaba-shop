package com.dmai.shop.service;

import com.dmai.shop.req.OrderParams;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 14:21:40
 */
public interface OrderService {

    /**
     * 保存订单
     * @param orderParams
     */
    void saveOrder(OrderParams orderParams);
}
