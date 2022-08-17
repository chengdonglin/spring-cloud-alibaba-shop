package com.dmai.shop.service;

import com.dmai.shop.bean.User;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 11:34:17
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     * @param userId
     * @return
     */
    User getUserById(Long userId);
}
