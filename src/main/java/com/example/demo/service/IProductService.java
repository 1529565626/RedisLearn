package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.Product;
import com.example.demo.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 产品 服务类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
public interface IProductService extends IService<Product> {

    /**
     * 店铺 添加商品
     * @param json
     * @return
     */
    @RequestMapping(value = "/add_product", method = RequestMethod.POST)
    ResponseMessage<Object> addProduct(String json, HttpServletRequest request) throws Exception;

    /**
     * 店铺 商品详情
     * @param json
     * @return
     */
    ResponseMessage<Object> selectProductParticulars(String json);

    /**
     * 店铺 编辑商品
     * @param json
     * @return
     */
    ResponseMessage<Object> editProduct(String json, HttpServletRequest request);
}
