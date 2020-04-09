package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.ProductAttributeValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 存储产品参数信息的表 Mapper 接口
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-21
 */
@Repository
@Mapper
public interface ProductAttributeValueMapper extends BaseMapper<ProductAttributeValue> {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<ProductAttributeValue> productAttributeValueList);
}
