package com.example.demo.entity.DTO;


import com.example.demo.entity.Product;
import com.example.demo.entity.ProductAttributeValue;
import com.example.demo.entity.SkuStock;

import java.util.List;

/**
 * @author Martin_W
 * @date 2020/3/20 0020 16:38
 */
public class ProductDTO extends Product {

    /**
     * 商品Sku值
     */
    private List<SkuStock> skuStockList;

    /**
     * 商品自定义参数值
     */
    private List<ProductAttributeValue> productAttributeValueList;

    public List<SkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<SkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<ProductAttributeValue> getProductAttributeValueList() {
        return productAttributeValueList;
    }

    public void setProductAttributeValueList(List<ProductAttributeValue> productAttributeValueList) {
        this.productAttributeValueList = productAttributeValueList;
    }
}
