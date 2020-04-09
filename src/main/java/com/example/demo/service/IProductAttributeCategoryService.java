package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.ProductAttributeCategory;
import com.example.demo.util.ResponseMessage;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-19
 */
public interface IProductAttributeCategoryService extends IService<ProductAttributeCategory> {

    /**
     * 商品属性类型 新增类型
     * @param json
     * @return
     */
    ResponseMessage<Object> addProductAttributeCategory(String json);

    /**
     * 商品属性类型 修改类型
     * @param json
     * @return
     */
    ResponseMessage<Object> editProductAttributeCategory(String json);

    /**
     * 商品属性类型 删除类型
     * @param json
     * @return
     */
    ResponseMessage<Object> delProductAttributeCategory(String json);

    /**
     * 商品属性类型 获取类型列表
     * @param json
     * @return
     */
    ResponseMessage<Object> getProductAttributeCategoryList(String json);
}
