package com.dmai.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 11:15:45
 */
@SpringBootApplication
@MapperScan("com.dmai.shop.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
