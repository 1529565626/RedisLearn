package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.ProductAttribute;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品属性参数表 Mapper 接口
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Mapper
public interface ProductAttributeMapper extends BaseMapper<ProductAttribute> {

}
