package com.dmai.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dmai.shop.bean.Order;
import com.dmai.shop.bean.OrderItem;
import com.dmai.shop.bean.Product;
import com.dmai.shop.bean.User;
import com.dmai.shop.mapper.OrderItemMapper;
import com.dmai.shop.mapper.OrderMapper;
import com.dmai.shop.req.OrderParams;
import com.dmai.shop.service.OrderService;
import com.dmai.shop.utils.constants.HttpCode;
import com.dmai.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 14:25:44
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private static final String USER_SERVER = "shop-user";

    private static final String PRODUCT_SERVER = "shop-product";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(OrderParams orderParams) {
        if (orderParams == null) {
            throw new RuntimeException("参数异常");
        }
        String userServiceUrl = this.getServiceUrl(USER_SERVER);
        String productServiceUrl = this.getServiceUrl(PRODUCT_SERVER);
        // User user = restTemplate.getForObject("http://localhost:8060/user/get/" + orderParams.getUserId(), User.class);
        User user = restTemplate.getForObject("http://" + userServiceUrl + "/user/get/" + orderParams.getUserId(), User.class);
        if (user == null) {
            throw new RuntimeException("未读取到用户信息:" + JSONObject.toJSONString(orderParams));
        }
        // Product product = restTemplate.getForObject("http://localhost:8070/product/get/" + orderParams.getProductId(), Product.class);
        Product product = restTemplate.getForObject("http://" + productServiceUrl + "/product/get/" + orderParams.getProductId(), Product.class);
        if (product == null) {
            throw new RuntimeException("未读取到商品信息:" + JSONObject.toJSONString(orderParams));
        }
        if (product.getProStock() < orderParams.getCount()) {
            throw new RuntimeException("商品库存不足:" + JSONObject.toJSONString(orderParams));
        }
        Order order = new Order();
        order.setAddress(user.getAddress());
        order.setPhone(user.getPhone());
        order.setUserId(user.getId());
        order.setUsername(user.getUsername());
        order.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        orderMapper.insert(order);

        OrderItem item = new OrderItem();
        item.setNumber(orderParams.getCount());
        item.setOrderId(order.getId());
        item.setProId(product.getId());
        item.setProName(product.getProName());
        item.setProPrice(product.getProPrice());
        orderItemMapper.insert(item);

        //Result<Integer> result = restTemplate.getForObject("http://localhost:8070/product/update_count/" + orderParams.getProductId() + "/" + orderParams.getCount(), Result.class);
        Result<Integer> result = restTemplate.getForObject("http://" + productServiceUrl + "/product/update_count/" + orderParams.getProductId() + "/" + orderParams.getCount(), Result.class);
        if (result.getCode() != HttpCode.SUCCESS) {
            throw new RuntimeException("扣减库存失败");
        }
        log.info("扣减库存成功");
    }


    /**
     * 获取动态服务地址
     * @param serviceName
     * @return
     */
    private String  getServiceUrl(String serviceName) {
        ServiceInstance serviceInstance = discoveryClient.getInstances(serviceName).get(0);
        return serviceInstance.getHost() + ":" + serviceInstance.getPort();
    }
}
