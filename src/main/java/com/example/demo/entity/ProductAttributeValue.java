package com.example.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 存储产品参数信息的表
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-21
 */
@TableName("product_attribute_value")
public class ProductAttributeValue extends Model<ProductAttributeValue> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("product_id")
    private String productId;
    @TableField("product_attribute_id")
    private String productAttributeId;
    /**
     * 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
     */
    private String value;


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

    public String getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(String productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProductAttributeValue{" +
        ", id=" + id +
        ", productId=" + productId +
        ", productAttributeId=" + productAttributeId +
        ", value=" + value +
        "}";
    }
}
