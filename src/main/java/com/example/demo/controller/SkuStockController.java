package com.example.demo.controller;


import com.example.demo.service.ISkuStockService;
import com.example.demo.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * sku的库存 前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Controller
@RequestMapping("/demo/skuStock")
public class SkuStockController {

    @Autowired
    private ISkuStockService skuStockService;

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseMessage<Object> updateSku(@RequestBody String json){
        return skuStockService.updateSku(json);
    }



}

