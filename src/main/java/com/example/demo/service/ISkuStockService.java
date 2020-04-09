package com.example.demo.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.SkuStock;
import com.example.demo.util.ResponseMessage;

/**
 * <p>
 * sku的库存 服务类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
public interface ISkuStockService extends IService<SkuStock> {


    /**
     * 商品Sku信息 修改
     * @param json
     * @return
     */
    ResponseMessage<Object> updateSku(String json);
}
