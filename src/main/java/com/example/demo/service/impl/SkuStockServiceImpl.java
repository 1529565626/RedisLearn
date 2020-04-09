package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.constant.ResultConstants;
import com.example.demo.entity.SkuStock;
import com.example.demo.mapper.SkuStockMapper;
import com.example.demo.service.ISkuStockService;
import com.example.demo.util.FavoritesHelper;
import com.example.demo.util.ResponseMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Service
public class SkuStockServiceImpl extends ServiceImpl<SkuStockMapper, SkuStock> implements ISkuStockService {

    /**
     * 商品Sku信息 修改
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> updateSku(String json) {
        String productId = JSON.parseObject(json).getString("productId");
        List<SkuStock> skuStockList = JSON.parseObject(json,List.class);
        String token = JSON.parseObject(json).getString("token");

        if (FavoritesHelper.isNull(productId) || FavoritesHelper.isNull(token)){
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }
        for (SkuStock sku:skuStockList) {
            if (baseMapper.updateById(sku)<1){
                return ResponseMessage.error("更新库存信息异常");
            }
        }
        return ResponseMessage.ok(2,"更新库存信息成功");
    }
}
