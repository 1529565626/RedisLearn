package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.SkuStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * sku的库存 Mapper 接口
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Repository
@Mapper
public interface SkuStockMapper extends BaseMapper<SkuStock> {

    /**
     * 批量插入
     * @param skuStockList
     * @return
     */
    int insertList(@Param("list") List<SkuStock> skuStockList);

}
