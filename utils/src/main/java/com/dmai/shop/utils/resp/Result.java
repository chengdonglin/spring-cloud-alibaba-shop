package com.dmai.shop.utils.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-16 09:38:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述
     */
    private String  codeMsg;

    /**
     * 返回数据
     */
    private T data;

}
