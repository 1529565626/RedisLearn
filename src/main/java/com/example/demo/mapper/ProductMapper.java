package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.DTO.ProductDTO;
import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 产品 Mapper 接口
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 获取单个商品的相关信息
     * @param productId
     * @return
     */
    ProductDTO getProductInfo(@Param("productId")String productId);
}
