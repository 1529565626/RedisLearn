package com.example.demo.controller;


import com.example.demo.service.IProductAttributeService;
import com.example.demo.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品属性参数表 前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@RestController
@RequestMapping(value="/demo/productAttribute",produces = AbstractUrl.PRODUCES)
public class ProductAttributeController {

    @Resource
    private IProductAttributeService iProductAttributeService;

    /**
     * 商品属性 新增
     * @param json
     * @return
     */
    @RequestMapping(value = "/add_attribute",method = RequestMethod.POST)
    public ResponseMessage<Object> addProductAttribute (@RequestBody String json){
        return iProductAttributeService.addProductAttribute(json);
    }

    /**
     * 商品属性 修改
     * @param json
     * @return
     */
    @RequestMapping(value = "/edit_attribute",method = RequestMethod.POST)
    public ResponseMessage<Object> editProductAttribute (@RequestBody String json){
        return iProductAttributeService.editProductAttribute(json);
    }

    /**
     * 商品属性 删除(批量)
     * @param json
     * @return
     */
    @RequestMapping(value = "/del_attribute",method = RequestMethod.POST)
    public ResponseMessage<Object> delProductAttribute (@RequestBody String json){
        return iProductAttributeService.delProductAttribute(json);
    }

    /**
     * 商品属性 查询属性列表或参数列表
     * @param json
     * @return
     */
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    public ResponseMessage<Object> getProductAttributeListById(@RequestBody String json){
        return iProductAttributeService.getProductAttributeListById(json);
    }

    /**
     * 商品属性 单个商品查询
     * @param json
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseMessage<Object> getProductAttributeById(@RequestBody String json){
        return iProductAttributeService.getProductAttributeById(json);
    }

    /**
     * 商品属性 根据类型查询
     * @param json
     * @return
     */
    @RequestMapping(value = "/get_by_category", method = RequestMethod.POST)
    public ResponseMessage<Object> getProductAttributeListByCategory(@RequestBody String json){
        return iProductAttributeService.getProductAttributeListByCategory(json);
    }
}

