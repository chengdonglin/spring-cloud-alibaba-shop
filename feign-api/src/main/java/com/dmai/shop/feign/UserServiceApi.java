package com.dmai.shop.feign;

import com.dmai.shop.bean.User;
import com.dmai.shop.utils.constants.ServiceNames;
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
@FeignClient(value = ServiceNames.USER_SERVICE_NAME)
public interface UserServiceApi {

    @GetMapping(value = "/user/get/{uid}")
    User getUser(@PathVariable("uid")Long uid);
}
