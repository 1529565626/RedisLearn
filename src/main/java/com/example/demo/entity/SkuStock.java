package com.example.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * sku的库存
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
@TableName("sku_stock")
public class SkuStock extends Model<SkuStock> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("product_id")
    private String productId;
    /**
     * sku编码
     */
    @TableField("sku_code")
    private String skuCode;
    private BigDecimal price;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 预警库存
     */
    @TableField("low_stock")
    private Integer lowStock;
    /**
     * 展示图片
     */
    private String pic;
    /**
     * 销量
     */
    private Integer sale;
    /**
     * 单品促销价格
     */
    @TableField("promotion_price")
    private BigDecimal promotionPrice;
    /**
     * 锁定库存
     */
    @TableField("lock_stock")
    private Integer lockStock;
    /**
     * 商品销售属性，json格式
     */
    @TableField("sp_data")
    private String spData;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    public String getSpData() {
        return spData;
    }

    public void setSpData(String spData) {
        this.spData = spData;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SkuStock{" +
        ", id=" + id +
        ", productId=" + productId +
        ", skuCode=" + skuCode +
        ", price=" + price +
        ", stock=" + stock +
        ", lowStock=" + lowStock +
        ", pic=" + pic +
        ", sale=" + sale +
        ", promotionPrice=" + promotionPrice +
        ", lockStock=" + lockStock +
        ", spData=" + spData +
        "}";
    }
}
