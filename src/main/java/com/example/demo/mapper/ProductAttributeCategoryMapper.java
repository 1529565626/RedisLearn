package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.ProductAttributeCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 产品属性分类表 Mapper 接口
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Repository
@Mapper
public interface ProductAttributeCategoryMapper extends BaseMapper<ProductAttributeCategory> {

}
