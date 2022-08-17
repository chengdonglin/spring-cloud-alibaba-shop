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
 *  订单明细
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 10:13:06
 */
@Data
@TableName("t_order_item")
public class OrderItem implements Serializable {


    private static final long serialVersionUID = 1326926129684892309L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @TableField(value = "id")
    private Long id;

    /**
     * 订单id
     */
    @TableField("t_order_id")
    private Long orderId;

    /**
     * 商品id
     */
    @TableField("t_pro_id")
    private Long proId;

    /**
     * 商品名称
     */
    @TableField("t_pro_name")
    private String proName;


    /**
     * 商品单价
     */
    @TableField("t_pro_price")
    private BigDecimal proPrice;

    /**
     * 购买数量
     */
    @TableField("t_number")
    private Integer number;
}
