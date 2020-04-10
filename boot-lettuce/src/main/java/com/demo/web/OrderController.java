package com.demo.web;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.demo.entity.Product;
import com.demo.entity.User;
import com.demo.service.impl.OrderServiceImpl;
import com.demo.service.impl.ProductServiceImpl;
import com.demo.util.ResponseMessage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
@RestController
@RequestMapping("/demo/order")
@Log
public class OrderController {

//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedisTemplate redisTemplate;


    private static ConcurrentHashMap<String ,Boolean> productSoldOutMap = new ConcurrentHashMap<>();


    @Autowired
    private ProductServiceImpl productService;

    @PostConstruct
    public void init(){
        List<Product> products = productService.selectList(new EntityWrapper<Product>().eq("product_delete_flag","0"));
        for (Product product : products) {
            redisTemplate.opsForValue().set(Product.getRedisKey()+product.getProductId(),product.getProductInventory()+"");
        }
    }


    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "/seckill", method = RequestMethod.POST)
    public ResponseMessage<Object> seckill(@RequestBody String productId){
        String proId = JSONObject.parseObject(productId).getString("productId");
//        v3.0 1432/s
        if (productSoldOutMap.get(proId)!=null){
            return ResponseMessage.error("商品已售罄");
        }

//        修改redis库存
        Long stock = redisTemplate.opsForValue().decrement(Product.getRedisKey()+proId);
//        v2.0 687/s
        if (stock<0){
            //还原库存 防止少买
            productSoldOutMap.put(proId,true);
            redisTemplate.opsForValue().increment(Product.getRedisKey()+proId);
            return ResponseMessage.error("商品已售罄");
        }

        try {
            orderService.seckill(proId);
        }catch (Exception e){
            log.info("订单创建失败,"+e);
//            下单失败修改redis库存
            if (productSoldOutMap.get(proId)!=null){
                productSoldOutMap.remove(proId);
            }
            redisTemplate.opsForValue().increment(Product.getRedisKey()+proId);
            return ResponseMessage.error("创建订单失败:"+e.getMessage());
        }
        return ResponseMessage.ok("订单创建成功");
    }

}

