package com.demo.web;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.demo.config.RestrictAccessAspect;
import com.demo.config.RestrictAccessAspectAop;
import com.demo.entity.Product;
import com.demo.entity.SkuStock;
import com.demo.entity.User;
import com.demo.service.impl.OrderServiceImpl;
import com.demo.service.impl.ProductServiceImpl;
import com.demo.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
@RestController
@Api(tags = "订单")
@RequestMapping("/demo/order")
@Log
public class OrderController {

    private final static Logger LOG = LoggerFactory.getLogger(OrderController.class);
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedisTemplate redisTemplate;


    private static ConcurrentHashMap<String ,Boolean> productSoldOutMap = new ConcurrentHashMap<>();


    @Autowired
    private ProductServiceImpl productService;

    @PostConstruct
    public void init(){
//        List<Product> products = productService.selectList(new EntityWrapper<Product>().eq("product_delete_flag","0"));
//        for (Product product : products) {
//            redisTemplate.opsForValue().set(Product.getRedisKey()+product.getProductId(),product.getProductInventory()+"");
//        }
        SkuStock skuStock = new SkuStock();
        skuStock.setId("baoweibei");
        skuStock.setStock(100L);
        redisTemplate.opsForHash().put("seckill","sku1",skuStock);
    }

    private int count = 0;
    @RequestMapping(value = "/seckill2", method = RequestMethod.POST)
    @ApiOperation(value="秒杀2",notes="秒杀2",httpMethod="POST")
    public ResponseMessage<Object> seckill2(@RequestBody String productId){
//        修改redis库存
        SkuStock skuStock = (SkuStock)redisTemplate.opsForHash().get("seckill","sku1");
        log.info("请求开始商品剩余库存:"+skuStock.getStock());
        Long stock = skuStock.getStock() - 1;
        if (stock <= 0){
            return ResponseMessage.error("库存不足,商品已经售完");
        }else{
//            生成订单
            skuStock.setStock(stock);
            redisTemplate.opsForHash().put("seckill","sku1",skuStock);
            log.info("请求结束商品剩余库存:"+skuStock.getStock());
        }
        System.out.println("总共请求次数:"+count++);
        return ResponseMessage.ok("订单创建成功");
    }

    @Autowired
    private OrderServiceImpl orderService;

    @RestrictAccessAspect(Count=true,restrictCount=5)
    @ApiOperation(value="秒杀",notes="秒杀",httpMethod="POST")
    @RequestMapping(value = "/seckill", method = RequestMethod.POST)
    public ResponseMessage<Object> seckill(@RequestBody String json){
        String productId = JSONObject.parseObject(json).getString("productId");

        if (productSoldOutMap.get(productId)!=null){
            return ResponseMessage.error("商品已售罄");
        }

        String userId = JSONObject.parseObject(json).getString("userId");
        if (redisTemplate.hasKey("seckill:"+productId+userId)){
            if (redisTemplate.opsForValue().increment("seckill:"+productId+userId,1)>1){
                return ResponseMessage.error("创建订单失败:你已经抢过一次了");
            }
        }else {
            redisTemplate.opsForValue().set("seckill:"+productId+userId,1,60, TimeUnit.MINUTES);
        }

//        修改redis库存
        Long stock = redisTemplate.opsForValue().decrement(Product.getRedisKey()+productId,1);
//        v2.0 687/s
        if (stock<0){
            //还原库存 防止少买
            productSoldOutMap.put(productId,true);
            redisTemplate.opsForValue().increment(Product.getRedisKey()+productId);
            return ResponseMessage.error("商品已售罄");
        }

        try {
            orderService.seckill(productId);
        }catch (Exception e){
            log.info("订单创建失败,"+e);
//            下单失败修改redis库存
            if (productSoldOutMap.get(productId)!=null){
                productSoldOutMap.remove(productId);
            }
            redisTemplate.opsForValue().decrement("seckill:"+productId+userId,1);
            redisTemplate.opsForValue().increment(Product.getRedisKey()+productId);
            return ResponseMessage.error("创建订单失败:"+e.getMessage());
        }
        return ResponseMessage.ok("订单创建成功");
    }

}

