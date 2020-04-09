package com.example.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2019-12-18
 */
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("product_id")
    private String productId;
    /**
     * 产品绑定店铺
     */
    @TableField("product_shop_id")
    private String productShopId;
    /**
     * 产品绑定类型
     */
    @TableField("product_type_id")
    private String productTypeId;
    /**
     * 产品缩略图(主图)
     */
    @TableField("product_cover")
    private String productCover;
    /**
     * 产品展示图片 最多5张
     */
    @TableField("product_images")
    private String productImages;
    /**
     * 产品标签
     */
    @TableField("product_label")
    private String productLabel;
    /**
     * 产品名称
     */
    @TableField("product_name")
    private String productName;
    /**
     * 产品关键字 最多60字符
     */
    @TableField("product_keyword")
    private String productKeyword;
    /**
     * 产品编码
     */
    @TableField("product_coding")
    private String productCoding;
    /**
     * 产品描述
     */
    @TableField("product_desc")
    private String productDesc;
    /**
     * 是否使用暖心币兑换 0是 1否
     */
    @TableField("product_nuan_status")
    private String productNuanStatus;
    /**
     * 产品价格区间
     */
    @TableField("product_range_price")
    private String productRangePrice;
    /**
     * 产品原价
     */
    @TableField("product_old_price")
    private BigDecimal productOldPrice;
    /**
     * 产品现价
     */
    @TableField("product_now_price")
    private BigDecimal productNowPrice;
    /**
     * 产品会员价
     */
    @TableField("product_vip_price")
    private BigDecimal productVipPrice;
    /**
     * 产品暖心币
     */
    @TableField("product_nuan_price")
    private Long productNuanPrice;
    /**
     * 产品销售量
     */
    @TableField("product_sales_number")
    private Long productSalesNumber;
    /**
     * 产品总库存
     */
    @TableField("product_inventory")
    private Long productInventory;
    /**
     * 是否使用规格 0使用 1不使用
     */
    @TableField("product_use_attr")
    private String productUseAttr;
    /**
     * 产品规格
     */
    @TableField("product_attr")
    private String productAttr;
    /**
     * 产品价格+库存
     */
    @TableField("product_price_stocks")
    private String productPriceStocks;
    /**
     * 是否有提现标准 0有 1没有
     */
    @TableField("product_standard_status")
    private String productStandardStatus;
    /**
     * 达到多少数量才可提现
     */
    @TableField("product_standard_num")
    private Integer productStandardNum;
    /**
     * 产品详情页
     */
    @TableField("product_details")
    private String productDetails;
    /**
     * 产品上架时间
     */
    @TableField("product_putaway_time")
    private Long productPutawayTime;
    /**
     * 产品创建时间
     */
    @TableField("product_create_time")
    private Long productCreateTime;
    /**
     * 产品评价数量
     */
    @TableField("product_evaluate_number")
    private Long productEvaluateNumber;
    /**
     * 产品推送状态 0推送 1不推送
     */
    @TableField("product_push")
    private String productPush;
    /**
     * 产品状态 0上架 1下架(入库)
     */
    @TableField("product_status")
    private String productStatus;
    /**
     * 产品删除状态 0正常 1删除
     */
    @TableField("product_delete_flag")
    private String productDeleteFlag;
    /**
     * 备用
     */
    @TableField("product_remark")
    private String productRemark;


    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public String getProductNuanStatus() {
        return productNuanStatus;
    }

    public void setProductNuanStatus(String productNuanStatus) {
        this.productNuanStatus = productNuanStatus;
    }

    public String getProductPush() {
        return productPush;
    }

    public void setProductPush(String productPush) {
        this.productPush = productPush;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductShopId() {
        return productShopId;
    }

    public void setProductShopId(String productShopId) {
        this.productShopId = productShopId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductCover() {
        return productCover;
    }

    public void setProductCover(String productCover) {
        this.productCover = productCover;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductKeyword() {
        return productKeyword;
    }

    public void setProductKeyword(String productKeyword) {
        this.productKeyword = productKeyword;
    }

    public String getProductCoding() {
        return productCoding;
    }

    public void setProductCoding(String productCoding) {
        this.productCoding = productCoding;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductRangePrice() {
        return productRangePrice;
    }

    public void setProductRangePrice(String productRangePrice) {
        this.productRangePrice = productRangePrice;
    }

    public BigDecimal getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(BigDecimal productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public BigDecimal getProductNowPrice() {
        return productNowPrice;
    }

    public void setProductNowPrice(BigDecimal productNowPrice) {
        this.productNowPrice = productNowPrice;
    }

    public BigDecimal getProductVipPrice() {
        return productVipPrice;
    }

    public void setProductVipPrice(BigDecimal productVipPrice) {
        this.productVipPrice = productVipPrice;
    }

    public Long getProductNuanPrice() {
        return productNuanPrice;
    }

    public void setProductNuanPrice(Long productNuanPrice) {
        this.productNuanPrice = productNuanPrice;
    }

    public Long getProductSalesNumber() {
        return productSalesNumber;
    }

    public void setProductSalesNumber(Long productSalesNumber) {
        this.productSalesNumber = productSalesNumber;
    }

    public Long getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(Long productInventory) {
        this.productInventory = productInventory;
    }

    public String getProductUseAttr() {
        return productUseAttr;
    }

    public void setProductUseAttr(String productUseAttr) {
        this.productUseAttr = productUseAttr;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    public String getProductPriceStocks() {
        return productPriceStocks;
    }

    public void setProductPriceStocks(String productPriceStocks) {
        this.productPriceStocks = productPriceStocks;
    }

    public String getProductStandardStatus() {
        return productStandardStatus;
    }

    public void setProductStandardStatus(String productStandardStatus) {
        this.productStandardStatus = productStandardStatus;
    }

    public Integer getProductStandardNum() {
        return productStandardNum;
    }

    public void setProductStandardNum(Integer productStandardNum) {
        this.productStandardNum = productStandardNum;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public Long getProductPutawayTime() {
        return productPutawayTime;
    }

    public void setProductPutawayTime(Long productPutawayTime) {
        this.productPutawayTime = productPutawayTime;
    }

    public Long getProductCreateTime() {
        return productCreateTime;
    }

    public void setProductCreateTime(Long productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    public Long getProductEvaluateNumber() {
        return productEvaluateNumber;
    }

    public void setProductEvaluateNumber(Long productEvaluateNumber) {
        this.productEvaluateNumber = productEvaluateNumber;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductDeleteFlag() {
        return productDeleteFlag;
    }

    public void setProductDeleteFlag(String productDeleteFlag) {
        this.productDeleteFlag = productDeleteFlag;
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark;
    }

    @Override
    protected Serializable pkVal() {
        return this.productId;
    }

    @Override
    public String toString() {
        return "Product{" +
        ", productId=" + productId +
        ", productShopId=" + productShopId +
        ", productTypeId=" + productTypeId +
        ", productCover=" + productCover +
        ", productImages=" + productImages +
        ", productName=" + productName +
        ", productKeyword=" + productKeyword +
        ", productCoding=" + productCoding +
        ", productDesc=" + productDesc +
        ", productRangePrice=" + productRangePrice +
        ", productOldPrice=" + productOldPrice +
        ", productNowPrice=" + productNowPrice +
        ", productVipPrice=" + productVipPrice +
        ", productNuanPrice=" + productNuanPrice +
        ", productSalesNumber=" + productSalesNumber +
        ", productInventory=" + productInventory +
        ", productUseAttr=" + productUseAttr +
        ", productAttr=" + productAttr +
        ", productPriceStocks=" + productPriceStocks +
        ", productStandardStatus=" + productStandardStatus +
        ", productStandardNum=" + productStandardNum +
        ", productDetails=" + productDetails +
        ", productPutawayTime=" + productPutawayTime +
        ", productCreateTime=" + productCreateTime +
        ", productEvaluateNumber=" + productEvaluateNumber +
        ", productStatus=" + productStatus +
        ", productDeleteFlag=" + productDeleteFlag +
        ", productRemark=" + productRemark +
        "}";
    }
}
