package com.demo.web;


import com.alibaba.fastjson.JSONObject;
import com.demo.entity.Product;
import com.demo.mapper.ProductMapper;
import com.demo.service.IProductService;
import com.demo.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class ProductController {
    @Autowired
    ProductMapper productMapper;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseMessage<Object> seckill(@RequestBody String productId){
        productId = JSONObject.parseObject(productId).getString("productId");
        Product product = new Product();
        System.out.println(productId);
        product.setProductId(productId);
        product = productMapper.selectOne(product);
        return ResponseMessage.ok(product);
    }
}

