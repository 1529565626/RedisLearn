package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.ProductAttribute;
import com.example.demo.util.ResponseMessage;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
public interface IProductAttributeService extends IService<ProductAttribute> {

    /**
     * 商品属性 新增
     * @param json
     * @return
     */
    ResponseMessage<Object> addProductAttribute(String json);

    /**
     * 商品属性 修改
     * @param json
     * @return
     */
    ResponseMessage<Object> editProductAttribute(String json);

    /**
     * 商品属性 删除
     * @param json
     * @return
     */
    ResponseMessage<Object> delProductAttribute(String json);

    /**
     * 商品属性 查询属性列表或参数列表
     * @param json
     * @return
     */
    ResponseMessage<Object> getProductAttributeListById(String json);

    /**
     * 商品属性 查询单个商品属性
     * @param json
     * @return
     */
    ResponseMessage<Object> getProductAttributeById(String json);

    /**
     * 商品属性 根据商品类型查询
     * @param json
     * @return
     */
    ResponseMessage<Object> getProductAttributeListByCategory(String json);
}
