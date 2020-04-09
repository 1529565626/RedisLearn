package com.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.demo.entity.BuyOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
public interface IOrderService extends IService<BuyOrder> {

    /**
     *
     * @param productId
     */
    void seckill(String productId);

}
