package com.dmai.shop.utils.exception;

import com.dmai.shop.utils.constants.HttpCode;
import com.dmai.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 *  全局异常捕获
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-16 09:37:25
 */
@RestControllerAdvice
@Slf4j
public class RestCatchExceptionHandler {

    /**
     * 全局异常处理，统一返回状态码
     * @param e
     * @return
     */
    public Result<String> handleException(Exception e) {
        log.error("服务器抛出了异常: {}",e);
        return new Result<String>(HttpCode.FAILURE,"执行失败",e.getMessage());
    }
}
