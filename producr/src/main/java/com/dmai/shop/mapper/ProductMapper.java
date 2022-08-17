package com.dmai.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmai.shop.bean.Product;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 11:50:02
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 扣减库存
     * @param count
     * @param id
     * @return
     */
    int updateProductStockById(@Param(value = "count") Integer count,@Param(value = "id") Long id);
}
