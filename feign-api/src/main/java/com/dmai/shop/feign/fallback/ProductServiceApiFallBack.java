package com.dmai.shop.feign.fallback;

import com.dmai.shop.bean.Product;
import com.dmai.shop.feign.ProductServiceApi;
import com.dmai.shop.utils.constants.HttpCode;
import com.dmai.shop.utils.resp.Result;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 16:23:19
 */
@Component
public class ProductServiceApiFallBack implements ProductServiceApi {
    @Override
    public Product getProduct(Long pid) {
        Product product = new Product();
        product.setId(-1L);
        return product;
    }

    @Override
    public Result updateCount(Long pid, Integer count) {
        Result<Integer> result = new Result<>();
        result.setCode(HttpCode.BLOCK);
        return result;
    }
}
