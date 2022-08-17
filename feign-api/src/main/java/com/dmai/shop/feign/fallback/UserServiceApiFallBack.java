package com.dmai.shop.feign.fallback;

import com.dmai.shop.bean.User;
import com.dmai.shop.feign.UserServiceApi;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 16:21:56
 */
@Component
public class UserServiceApiFallBack implements UserServiceApi {
    @Override
    public User getUser(Long uid) {
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
