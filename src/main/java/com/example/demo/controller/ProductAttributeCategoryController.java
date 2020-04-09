package com.example.demo.controller;


import com.example.demo.service.IProductAttributeCategoryService;
import com.example.demo.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 产品属性分类表 前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@RestController
@RequestMapping(value="/demo/productAttributeCategory",produces = AbstractUrl.PRODUCES)
public class ProductAttributeCategoryController {
    @Resource
    private IProductAttributeCategoryService iProductACateService;

    /**
     * 添加类型
     * @param json
     * @return
     */
    @RequestMapping(value = "/add_category",method = RequestMethod.POST)
    public ResponseMessage<Object> addProductAttributeCategory(@RequestBody String json){
        return iProductACateService.addProductAttributeCategory(json);
    }

    /**
     * 修改类型
     * @param json
     * @return
     */
    @RequestMapping(value = "/edit_category",method = RequestMethod.POST)
    public ResponseMessage<Object> editProductAttributeCategory(@RequestBody String json){
        return iProductACateService.editProductAttributeCategory(json);
    }

    /**
     * 删除类型
     * @param json
     * @return
     */
    @RequestMapping(value = "/del_category",method = RequestMethod.POST)
    public ResponseMessage<Object> delProductAttributeCategory(@RequestBody String json){
        return iProductACateService.delProductAttributeCategory(json);
    }

    @RequestMapping(value = "/get_category_list",method = RequestMethod.POST)
    public ResponseMessage<Object> getProductAttributeCategoryList(@RequestBody String json){
        return iProductACateService.getProductAttributeCategoryList(json);
    }

}

