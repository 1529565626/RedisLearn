package com.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 产品 Mapper 接口
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    @Update("UPDATE product SET product_inventory = product_inventory-1 WHERE product_id = #{productId} AND product_inventory>0")
    int updateStock(@Param("productId") String productId);
}
