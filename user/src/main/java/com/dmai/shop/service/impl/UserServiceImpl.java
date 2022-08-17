package com.dmai.shop.service.impl;

import com.dmai.shop.bean.User;
import com.dmai.shop.mapper.UserMapper;
import com.dmai.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 11:35:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectById(userId);
    }
}
