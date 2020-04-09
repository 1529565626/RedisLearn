package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.constant.ResultConstants;
import com.example.demo.entity.ProductAttributeCategory;
import com.example.demo.mapper.ProductAttributeCategoryMapper;
import com.example.demo.service.IProductAttributeCategoryService;

import com.example.demo.util.FavoritesHelper;
import com.example.demo.util.PageUtil;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.util.GuidGeneratorUtil;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory> implements IProductAttributeCategoryService {
//    /**
//     * redis
//     */
//    @Resource
//    private IRedisCache iRedisCache;


    /**
     * 商品属性类型 新增类型
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> addProductAttributeCategory(String json) {
        ProductAttributeCategory category = JSON.parseObject(json,ProductAttributeCategory.class);
        String token = JSON.parseObject(json).getString("token");
        if (FavoritesHelper.isNull(token)|| FavoritesHelper.isNull(category.getName())){
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

        String uuid = GuidGeneratorUtil.generate();
        category.setId(uuid);
        category.setAttributeCount(0);
        category.setParamCount(0);
        if (baseMapper.insert(category) != 1 ){
            return ResponseMessage.error("添加失败");
        }
        return ResponseMessage.ok(uuid);
    }

    /**
     * 商品属性类型 修改类型
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> editProductAttributeCategory(String json) {
        ProductAttributeCategory category = JSON.parseObject(json,ProductAttributeCategory.class);
        String token = JSON.parseObject(json).getString("token");
        if (FavoritesHelper.isNull(token)||FavoritesHelper.isNull(category.getId())||FavoritesHelper.isNull(category.getName())){
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

        if (baseMapper.updateById(category) != 1){
            return ResponseMessage.error("修改失败");
        }
        return ResponseMessage.ok(2, "修改成功");
    }

    /**
     * 商品属性类型 删除类型
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> delProductAttributeCategory(String json) {
        ProductAttributeCategory category = JSON.parseObject(json,ProductAttributeCategory.class);
        String token = JSON.parseObject(json).getString("token");
        if (FavoritesHelper.isNull(token)||FavoritesHelper.isNull(category.getId())){
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
        category.setCategoryDeleteFlag("1");

        if (baseMapper.updateById(category) != 1){
            return ResponseMessage.error("删除失败");
        }
        return ResponseMessage.ok(2, "删除成功");
    }

    /**
     * 商品属性类型 获取类型列表
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> getProductAttributeCategoryList(String json) {
        //获取页码 页大小
        int page = JSON.parseObject(json).getIntValue("page");
        int pageSize = JSON.parseObject(json).getIntValue("pageSize");
//        String token = JSON.parseObject(json).getString("token");

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

        //定义条件
        if (page == 0 || page == 1) {
            page = 1;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        PageUtil<ProductAttributeCategory> pageInfo = new PageUtil<>(page,pageSize);
        List<ProductAttributeCategory> cateList = baseMapper.selectList(new EntityWrapper<ProductAttributeCategory>().eq("category_delete_flag","0"));
        pageInfo.setRecords(cateList);
        return ResponseMessage.ok(pageInfo);
    }
}
