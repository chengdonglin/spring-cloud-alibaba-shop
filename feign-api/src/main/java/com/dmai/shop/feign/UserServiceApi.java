package com.dmai.shop.feign;

import com.dmai.shop.bean.User;
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
@FeignClient("shop-user")
public interface UserServiceApi {

    @GetMapping(value = "/user/get/{uid}")
    User getUser(@PathVariable("uid")Long uid);
}
