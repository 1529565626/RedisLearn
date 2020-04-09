package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.constant.ResultConstants;
import com.example.demo.entity.ProductAttribute;
import com.example.demo.entity.ProductAttributeCategory;
import com.example.demo.mapper.ProductAttributeCategoryMapper;
import com.example.demo.mapper.ProductAttributeMapper;
import com.example.demo.service.IProductAttributeService;
import com.example.demo.util.FavoritesHelper;
import com.example.demo.util.PageUtil;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.util.GuidGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements IProductAttributeService {

//    /**
//     * redis
//     */
//    @Resource
//    private IRedisCache iRedisCache;

    @Autowired
    private ProductAttributeCategoryMapper productAttributeCategoryMapper;

    private boolean checkNull(ProductAttribute productAttribute){
        return FavoritesHelper.isNull(productAttribute.getId())||FavoritesHelper.isNull(productAttribute.getName())
                ||FavoritesHelper.isNull(productAttribute.getProductAttributeCategoryId())
                ||FavoritesHelper.isNull(productAttribute.getSelectType())||FavoritesHelper.isNull(productAttribute.getSearchType())
                ||FavoritesHelper.isNull(productAttribute.getFilterType())||FavoritesHelper.isNull(productAttribute.getHandAddStatus())
                ||FavoritesHelper.isNull(productAttribute.getInputType())||FavoritesHelper.isNull(productAttribute.getRelatedStatus())
                ||(productAttribute.getInputType()=="1" && FavoritesHelper.isNull(productAttribute.getInputList()))
                ||FavoritesHelper.isNull(productAttribute.getType());
    }

    /**
     * 商品属性 新增
     * 新增商品属性以后需要更新商品属性分类数量
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> addProductAttribute(String json) {
        ProductAttribute productAttribute = JSON.parseObject(json,ProductAttribute.class);
        String token = JSON.parseObject(json).getString("token");
        //新增是添加id
        String uuid = GuidGeneratorUtil.generate();
        productAttribute.setId(uuid);

        if (checkNull(productAttribute)){
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

        productAttribute.setAttributeDeleteFlag("0");
        if (baseMapper.insert(productAttribute) != 1){
            return ResponseMessage.error("添加失败");
        }

        ProductAttributeCategory category = productAttributeCategoryMapper.selectById(productAttribute.getProductAttributeCategoryId());
        if (category == null){
            return ResponseMessage.error("添加商品属性的类型异常");
        }
        if (productAttribute.getType().equals("1")){
            category.setParamCount(category.getParamCount()+1);
        }else if (productAttribute.getType().equals("0")){
            category.setAttributeCount(category.getAttributeCount()+1);
        }
        if (productAttributeCategoryMapper.updateById(category) != 1){
            return ResponseMessage.error("更新参数数量失败");
        }
        return ResponseMessage.ok(uuid);
    }

    /**
     * 商品属性 修改
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> editProductAttribute(String json) {
        ProductAttribute productAttribute = JSON.parseObject(json,ProductAttribute.class);
//        String token = JSON.parseObject(json).getString("token");
        if (checkNull(productAttribute)){
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

//        如果商品属性分类发生了变化   需要调整变化前后的商品属性的参数数量值
        ProductAttribute oldproductAttribute = baseMapper.selectById(productAttribute.getId());
        if (!oldproductAttribute.getProductAttributeCategoryId().equals(productAttribute.getProductAttributeCategoryId())){
            ProductAttributeCategory oldcategory = productAttributeCategoryMapper.selectById(oldproductAttribute.getProductAttributeCategoryId());
            ProductAttributeCategory newcategory = productAttributeCategoryMapper.selectById(productAttribute.getProductAttributeCategoryId());
            if (oldproductAttribute.getType().equals("1")){
                oldcategory.setParamCount(oldcategory.getParamCount()-1);
                newcategory.setParamCount(newcategory.getParamCount()+1);
            }else if (oldproductAttribute.getType().equals("0")){
                oldcategory.setAttributeCount(oldcategory.getAttributeCount()-1);
                newcategory.setAttributeCount(newcategory.getAttributeCount()+1);
            }
            if (productAttributeCategoryMapper.updateById(oldcategory) != 1  || productAttributeCategoryMapper.updateById(newcategory) != 1){
                return ResponseMessage.error("更新参数数量失败");
            }
        }

        if (baseMapper.updateById(productAttribute) != 1){
            return ResponseMessage.error("修改失败");
        }
        return ResponseMessage.ok(2,"修改成功");
    }

    /**
     * 商品属性 删除
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> delProductAttribute(String json) {
//        ProductAttribute productAttribute = JSON.parseObject(json,ProductAttribute.class);
        String delId =  JSON.parseObject(json).getString("delids");
        String token = JSON.parseObject(json).getString("token");
        if (FavoritesHelper.isNull(delId)||FavoritesHelper.isNull(token)){
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

        String[] ids = delId.split(",");
        ProductAttribute productAttribute = baseMapper.selectById(ids[0]);
        int finish = 0;
        for (int i = 0;i<ids.length;i++){
            ProductAttribute temp = baseMapper.selectById(ids[i]);
            if (temp != null ){
                temp.setAttributeDeleteFlag("1");
                if (baseMapper.updateById(temp) == 1){
                    finish++;
                }
            }
        }

//        更新参数数量
        ProductAttributeCategory category = productAttributeCategoryMapper.selectById(productAttribute.getProductAttributeCategoryId());
        if (productAttribute.getType().equals("1")){
            category.setParamCount(category.getParamCount()-finish);
        }else if (productAttribute.getType().equals("0")){
            category.setAttributeCount(category.getAttributeCount()-finish);
        }
        if (productAttributeCategoryMapper.updateById(category) != 1){
            return ResponseMessage.error("更新参数数量失败");
        }

        return ResponseMessage.ok(2,"删除成功"+finish+"条数据");
    }

    /**
     * 商品属性 查询属性列表或参数列表
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> getProductAttributeListById(String json) {
        String cid = JSON.parseObject(json).getString("categoryId");
        String type = JSON.parseObject(json).getString("type");
        //获取页码 页大小
        int page = JSON.parseObject(json).getIntValue("page");
        int pageSize = JSON.parseObject(json).getIntValue("pageSize");
        String token = JSON.parseObject(json).getString("token");

        if (FavoritesHelper.isNull(cid)||FavoritesHelper.isNull(type)||FavoritesHelper.isNull(token)){
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

        //定义条件
        if (page == 0 || page == 1) {
            page = 1;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        PageUtil<ProductAttribute> pageInfo = new PageUtil<>(page,pageSize);
        List<ProductAttribute> productAttributeList = baseMapper.selectList(new EntityWrapper<ProductAttribute>()
                .eq("product_attribute_category_id",cid).eq("attribute_delete_flag","0")
                .eq("type",type).orderBy("sort",false));
        pageInfo.setRecords(productAttributeList);
        return ResponseMessage.ok(pageInfo);
    }

    /**
     * 商品属性 查询单个商品属性
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> getProductAttributeById(String json) {
        String id = JSON.parseObject(json).getString("id");
        String token = JSON.parseObject(json).getString("token");
        if (FavoritesHelper.isNull(id)||FavoritesHelper.isNull(token)){
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

        ProductAttribute productAttribute = baseMapper.selectById(id);
        if (productAttribute == null || productAttribute.getAttributeDeleteFlag().equals("1")){
            return ResponseMessage.error("该数据不存在");
        }
        return ResponseMessage.ok(productAttribute);
    }

    /**
     * 商品属性 根据商品类型查询
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> getProductAttributeListByCategory(String json) {
        String cid = JSON.parseObject(json).getString("categoryId");
        String token = JSON.parseObject(json).getString("token");
        if (FavoritesHelper.isNull(cid)||FavoritesHelper.isNull(token)){
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

        List<ProductAttribute> attributesList = baseMapper.selectList(new EntityWrapper<ProductAttribute>().eq("product_attribute_category_id",cid)
                .eq("attribute_delete_flag","0"));
        return ResponseMessage.ok(attributesList);
    }
}
