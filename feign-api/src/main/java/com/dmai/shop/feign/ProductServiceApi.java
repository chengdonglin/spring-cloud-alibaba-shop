package com.dmai.shop.feign;

import com.dmai.shop.bean.Product;
import com.dmai.shop.feign.fallback.ProductServiceApiFallBack;
import com.dmai.shop.utils.constants.ServiceNames;
import com.dmai.shop.utils.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 15:30:35
 */
@FeignClient(value = ServiceNames.PRODUCT_SERVICE_NAME,fallback = ProductServiceApiFallBack.class)
public interface ProductServiceApi {

    @GetMapping(value = "/product/get/{pid}")
    Product getProduct(@PathVariable("pid")Long pid);


    @GetMapping(value = "/product/update_count/{pid}/{count}")
    Result updateCount(@PathVariable("pid")Long pid,@PathVariable("count")Integer count);
}
