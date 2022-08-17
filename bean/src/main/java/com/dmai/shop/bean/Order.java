package com.dmai.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *  订单
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 10:13:06
 */
@Data
@TableName("t_order")
public class Order implements Serializable {


    private static final long serialVersionUID = 2180958671655890399L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @TableField(value = "id")
    private Long id;

    /**
     * 用户id
     */
    @TableField("t_user_id")
    private Long userId;

    /**
     * 用户名
     */
    @TableField("t_user_name")
    private String username;

    /**
     * 手机号
     */
    @TableField("t_phone")
    private String phone;


    /**
     * 地址
     */
    @TableField("t_address")
    private String address;

    /**
     * 商品总价
     */
    @TableField("t_total_price")
    private BigDecimal totalPrice;
}
