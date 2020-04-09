package com.example.demo.controller;


import com.example.demo.service.IProductService;
import com.example.demo.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 产品 前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@RestController
@RequestMapping(value ="/demo/product", produces = AbstractUrl.PRODUCES)
public class ProductController {

    @Resource
    private IProductService iProductService;

    /**
     * 添加产品
     *
     * @param json
     * @return
     */
    @RequestMapping(value = AbstractUrl.ADD_PRODUCT, method = RequestMethod.POST)
    public ResponseMessage<Object> addProduct(@RequestBody String json, HttpServletRequest request) throws Exception {
        return iProductService.addProduct(json,request);
    }

    /**
     * 产品详情
     *
     * @param json
     * @return
     */
    @RequestMapping(value = AbstractUrl.PRODUCT_PARTICULARS, method = RequestMethod.POST)
    public ResponseMessage<Object> selectProductParticulars(@RequestBody String json) {
        return iProductService.selectProductParticulars(json);
    }

    /**
     * 编辑产品
     *
     * @param json
     * @return
     */
    @RequestMapping(value = AbstractUrl.EDIT_PRODUCT, method = RequestMethod.POST)
    public ResponseMessage<Object> editProduct(@RequestBody String json, HttpServletRequest request) {
        return iProductService.editProduct(json,request);
    }
}

