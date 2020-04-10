package com.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demo.util.GuidGeneratorUtil;
import com.demo.entity.BuyOrder;
import com.demo.entity.Product;
import com.demo.mapper.OrderMapper;
import com.demo.mapper.ProductMapper;
import com.demo.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, BuyOrder> implements IOrderService {


    @Resource
    private ProductMapper productMapper;

    /**
     *
     * @param productId
     */
    @Override
    public void seckill(String productId){

        Product product = productMapper.selectById(productId);
        if (product.getProductInventory()<=0){
            throw new RuntimeException("商品已售完");
        }

//        创建秒杀订单
        String orderId = GuidGeneratorUtil.generate();
        BuyOrder order = new BuyOrder();
        order.setId(orderId);
        order.setProductId(productId);
        order.setAmount(product.getProductNowPrice());
        baseMapper.insert(order);

        int updatenum = productMapper.updateStock(productId);
        if (updatenum <= 0 ){
            throw new RuntimeException("订单创建失败");
        }

    }

}
