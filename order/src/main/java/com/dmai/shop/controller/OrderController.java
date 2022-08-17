package com.dmai.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.dmai.shop.req.OrderParams;
import com.dmai.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 14:43:11
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    @Qualifier(value = "orderServiceV3")
    private OrderService orderService;

    @PostMapping(value = "submit_order")
    public String submitOrder(@RequestBody OrderParams orderParams) {
        log.info("提交订单传递参数: {}", JSONObject.toJSONString(orderParams));
        orderService.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/test_sentinel")
    public String testSentinel(){
        log.info("测试Sentinel");
        return "sentinel";
    }
}
