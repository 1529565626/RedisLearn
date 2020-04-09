package com.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
