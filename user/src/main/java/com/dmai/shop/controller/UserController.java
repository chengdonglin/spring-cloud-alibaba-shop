package com.dmai.shop.controller;

import com.dmai.shop.bean.User;
import com.dmai.shop.service.UserService;
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
 * @since 2022-08-17 11:38:22
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{uid}")
    public User getUser(@PathVariable("uid")Long uid) {
        User user = userService.getUserById(uid);
        log.info("获取到用户信息为: {}",user);
        return user;
    }
}
