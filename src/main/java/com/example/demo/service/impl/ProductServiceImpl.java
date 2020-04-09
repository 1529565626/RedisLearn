package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.constant.ResultConstants;
import com.example.demo.entity.DTO.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductAttributeValue;
import com.example.demo.entity.SkuStock;
import com.example.demo.mapper.ProductAttributeValueMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.SkuStockMapper;
import com.example.demo.service.IProductService;
import com.example.demo.util.FavoritesHelper;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.util.GuidGeneratorUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    /**
     * 商品SkuStock
     */
    @Resource
    private SkuStockMapper skuStockMapper;

    /**
     * 商品信息
     */
    @Resource
    private ProductMapper productMapper;

    /**
     * 商品自定义参数值
     */
    @Resource
    private ProductAttributeValueMapper productAttributeValueMapper;

    private Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

    /**
     * 店铺 添加商品
     *
     * @param json
     * @param request
     * @return
     */
    @Override
    public ResponseMessage<Object> addProduct(String json, HttpServletRequest request) throws Exception {
        //数据转换
        ProductDTO product = JSON.parseObject(json, ProductDTO.class);
        //获取json里的token
        String token = JSON.parseObject(json).getString("token");
        //判断必填项
        if (FavoritesHelper.isNull(token)
                || FavoritesHelper.isNull(product.getProductTypeId())
                || FavoritesHelper.isNull(product.getProductCover())
                || FavoritesHelper.isNull(product.getProductImages())
                || FavoritesHelper.isNull(product.getProductName())
                || FavoritesHelper.isNull(product.getProductKeyword())
                || FavoritesHelper.isNull(product.getProductDesc())
                || FavoritesHelper.isNull(product.getProductCoding())
                || FavoritesHelper.isNull(product.getProductNuanStatus())
                || FavoritesHelper.isNull(product.getProductRangePrice())
                || FavoritesHelper.isNull(product.getProductUseAttr())
                || FavoritesHelper.isNull(product.getProductDetails())
                || FavoritesHelper.isNull(product.getProductStatus())
                || FavoritesHelper.isNull(product.getProductStandardStatus())

        ) {
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }
        //decimal int 判空
        if (product.getProductNowPrice().compareTo(BigDecimal.ZERO) == 0 || product.getProductNowPrice() == null
                || product.getProductOldPrice().compareTo(BigDecimal.ZERO) == 0 || product.getProductOldPrice() == null
                || product.getProductVipPrice().compareTo(BigDecimal.ZERO) == 0 || product.getProductVipPrice() == null
                || product.getProductInventory() == 0 || product.getProductInventory() == null
        ) {
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }
        //限制关键字   1个汉字2个字节 1个数字1个字节 最多60个字节
        if (product.getProductKeyword().getBytes("GBK").length > 60) {
            return ResponseMessage.error("关键字超长");
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

//        //缩略图(主图)  将图片转移到正式文件夹
//        String code3 = null;
//        if (product.getProductCover() != null) {
//            //存放处理好之后的数据
//            code3 = ApplicationUtils.add(product.getProductCover(), NEWFOLDER, request);
//            if (code3 == null) {
//                return ResponseMessage.error("上传失败");
//            }
//        }
//
//
//        //产品图片 将图片转移到正式文件夹
//        String code = null;
//        if (product.getProductImages() != null) {
//            //存放处理好之后的数据
//            code = ApplicationUtils.add(product.getProductImages(), NEWFOLDER, request);
//            if (code == null) {
//                return ResponseMessage.error("上传失败");
//            }
//        }

        String uuid = GuidGeneratorUtil.generate();
        product.setProductId(uuid);
//        product.setProductShopId(shopId);
//        product.setProductCover(code3);
//        product.setProductImages(code);
        product.setProductCreateTime(System.currentTimeMillis());
        if("0".equals(product.getProductStatus())){
            product.setProductPutawayTime(System.currentTimeMillis());
        }
        product.setProductDeleteFlag("0");
        //添加sku库存信息
        handleSkuStockCode(product.getSkuStockList(),product.getProductCreateTime().toString());
        relateAndInsertList(skuStockMapper,product.getSkuStockList(),uuid);
        //添加商品参数,添加自定义商品规格
        relateAndInsertList(productAttributeValueMapper, product.getProductAttributeValueList(), uuid);

        if (baseMapper.insert(product) != 1) {
            return ResponseMessage.error("添加失败");
        }
        return ResponseMessage.ok(uuid);
    }

    /**
     * 处理sku码 商品创建时间+i
     * @param skuStocks
     * @param creatTimeMillis
     */
    private void handleSkuStockCode(List<SkuStock> skuStocks, String creatTimeMillis){
        if (CollectionUtils.isEmpty(skuStocks)){
            return;
        }
        for (int i = 0; i < skuStocks.size(); i++){
            SkuStock sku = skuStocks.get(i);
            if (StringUtils.isEmpty(sku.getSkuCode())){
                StringBuilder skuCode = new StringBuilder();
//                生成sku码
                skuCode.append(creatTimeMillis);
                skuCode.append(String.format("%03d",i+1));
                sku.setSkuCode(skuCode.toString());
            }
        }

    }

    /**
     * 建立和插入关系表操作
     * @param mapper
     * @param dataList
     * @param ProductId
     */
    private void relateAndInsertList(Object mapper,List dataList,String ProductId){
        try {
            if (CollectionUtils.isEmpty(dataList)){
                return;
            }
            for (Object item : dataList){
                Method setId = item.getClass().getMethod("setId",String.class);
                String uuid = GuidGeneratorUtil.generate();
                setId.invoke(item,uuid);
                Method setProductId = item.getClass().getMethod("setProductId",String.class);
                setProductId.invoke(item,ProductId);
            }
            Method insertList = mapper.getClass().getMethod("insertList",List.class);
            insertList.invoke(mapper,dataList);
        } catch (Exception e){
            LOG.warn("创建产品时出错:",e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * 店铺 商品详情
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> selectProductParticulars(String json) {
        //获取json里的产品id
        String productId = JSON.parseObject(json).getString("productId");
        //判空 id
        if (FavoritesHelper.isNull(productId)) {
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }
        ProductDTO product = productMapper.getProductInfo(productId);


        //商品 删除状态  上下架状态
        if ("1".equals(product.getProductDeleteFlag())) {
            return ResponseMessage.error("该产品已经不存在啦...");
        }
        return ResponseMessage.ok(product);
    }


    /**
     * 店铺 编辑商品
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> editProduct(String json, HttpServletRequest request) {
        //数据转换
        ProductDTO product = JSON.parseObject(json, ProductDTO.class);
//        Product product = JSON.parseObject(json, Product.class);
        //判断必填
        if (FavoritesHelper.isNull(product.getProductId())) {
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }

        Product pro = baseMapper.selectById(product.getProductId());
        //产品状态
        if (!pro.getProductStatus().equals(product.getProductStatus())
                && !"1".equals(product.getProductStatus())
                && !"2".equals(product.getProductStatus())
        ) {
            product.setProductPutawayTime(System.currentTimeMillis());
        }

//        修改sku信息
        handleUpdateSkuStockList(product);
//        修改商品参数,添加自定义商品规格
        productAttributeValueMapper.delete(new EntityWrapper<ProductAttributeValue>().eq("product_id",product.getProductId()));
        relateAndInsertList(productAttributeValueMapper,product.getProductAttributeValueList(),product.getProductId());

        if (baseMapper.updateById(product) != 1) {
            return ResponseMessage.error("修改失败");
        }
        return ResponseMessage.ok(2, "修改成功");
    }

    private void handleUpdateSkuStockList(ProductDTO product){
//        当前Sku信息
        List<SkuStock> currSkuList = product.getSkuStockList();
//        如果当前没有Sku直接删除
        if (CollectionUtils.isEmpty(currSkuList)){
            skuStockMapper.delete(new EntityWrapper<SkuStock>().eq("product_id",product.getProductId()));
            return;
        }
//        获取初始sku信息
        List<SkuStock> oriSkuStockList = skuStockMapper.selectList(new EntityWrapper<SkuStock>().eq("product_id",product.getProductId()));
//        获取新增sku的部分
        List<SkuStock> insertSkuList = currSkuList.stream().filter(item->item.getId()==null).collect(Collectors.toList());
//        获取需要更新的sku信息
        List<SkuStock> updateSkuList = currSkuList.stream().filter(item->item.getId()!=null).collect(Collectors.toList());
        List<String> updateSkuIds = updateSkuList.stream().map(SkuStock::getId).collect(Collectors.toList());
//        获取需要删除的sku信息
        List<SkuStock> removeSkuList = oriSkuStockList.stream().filter(item-> !updateSkuIds.contains(item.getId())).collect(Collectors.toList());
//        处理需要更新的sku信息
        handleSkuStockCode(insertSkuList,product.getProductCreateTime().toString());
        handleSkuStockCode(updateSkuList,product.getProductCreateTime().toString());
//        新增sku
        if (!CollectionUtils.isEmpty(insertSkuList)){
            relateAndInsertList(skuStockMapper,insertSkuList,product.getProductId());
        }
//        删除sku
        if (!CollectionUtils.isEmpty(removeSkuList)){
            List<String> removeSkuIds = removeSkuList.stream().map(SkuStock::getId).collect(Collectors.toList());
            skuStockMapper.deleteBatchIds(removeSkuIds);
        }
//        修改sku
        if (!CollectionUtils.isEmpty(updateSkuIds)){
            for (SkuStock skuStock : updateSkuList){
                skuStockMapper.updateById(skuStock);
            }
        }
    }


}
