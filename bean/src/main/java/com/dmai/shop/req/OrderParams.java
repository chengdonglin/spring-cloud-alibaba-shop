package com.dmai.shop.req;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 14:23:50
 */
@Data
public class OrderParams {

    private Long userId;

    private Long productId;

    private Integer count;
}
