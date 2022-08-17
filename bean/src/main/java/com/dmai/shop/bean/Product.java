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
 *  商品
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 10:13:06
 */
@Data
@TableName("t_product")
public class Product implements Serializable {


    private static final long serialVersionUID = -6955045695837046237L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @TableField(value = "id")
    private Long id;

    /**
     * 商品名称
     */
    @TableField("t_pro_name")
    private String proName;

    /**
     * 商品价格
     */
    @TableField("t_pro_price")
    private BigDecimal proPrice;

    /**
     * 商品库存
     */
    @TableField("t_pro_stock")
    private Integer proStock;
}
