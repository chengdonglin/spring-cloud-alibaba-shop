package com.dmai.shop.controller;

import com.dmai.shop.bean.Product;
import com.dmai.shop.service.ProductService;
import com.dmai.shop.utils.constants.HttpCode;
import com.dmai.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 11:58:08
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/get/{pid}")
    public Product getProduct(@PathVariable(value = "pid")Long pid) {
        Product product = productService.getProductById(pid);
        log.info("获取商品信息为: {}",product);
        return product;
    }

    @GetMapping(value = "/update_count/{pid}/{count}")
    public Result<Integer> updateCount(@PathVariable("pid") Long pid,
                                       @PathVariable("count") Integer count){
        log.info("更新商品库存传递的参数为: 商品id:{}, 购买数量:{} ", pid, count);
        Integer updateCount = productService.updateProductStockById(count, pid);
        Result<Integer> result = new Result<>(HttpCode.SUCCESS, "执行成功",updateCount);
        return result;
    }

}
