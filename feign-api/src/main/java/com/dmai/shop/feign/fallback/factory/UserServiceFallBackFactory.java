package com.dmai.shop.feign.fallback.factory;

import com.dmai.shop.bean.User;
import com.dmai.shop.feign.UserServiceApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 16:34:29
 */
@Component
public class UserServiceFallBackFactory implements FallbackFactory<UserServiceApi> {
    @Override
    public UserServiceApi create(Throwable throwable) {
        return new UserServiceApi() {
            @Override
            public User getUser(Long uid) {
                User user = new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
