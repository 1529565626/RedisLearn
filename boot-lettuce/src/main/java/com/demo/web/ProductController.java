package com.demo.web;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.demo.entity.Product;
import com.demo.entity.User;
import com.demo.mapper.ProductMapper;
import com.demo.service.IProductService;
import com.demo.service.impl.ProductServiceImpl;
import com.demo.util.ResponseMessage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 产品 前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
@RestController
@RequestMapping("/demo/product")
@Log
public class ProductController {

//    @Resource(name="redisTemplate")//k  user hk id hv object
//    private HashOperations<String  , String, Product> hashTemp;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private ProductServiceImpl productService;

    /**
     * 商品初始化,将商品放入redis
     */
    @PostConstruct
    public void init(){
        long startTime = System.currentTimeMillis();
        List<Product> products = productService.selectList(new EntityWrapper<Product>().eq("product_delete_flag","0"));
        log.info("商品开始加载入库存");
        for (Product product : products) {
            redisTemplate.opsForHash().put(Product.getRedisKey(),product.getProductId(),product);
        }
        for (Product product : products) {
            Product product1 = (Product) redisTemplate.opsForHash().get(Product.getRedisKey(),product.getProductId());
            System.out.println(product.toString());
        }

        log.info("商品加载入内存成功,共"+products.size()+"条,耗时:"+(System.currentTimeMillis()-startTime));

    }


}

