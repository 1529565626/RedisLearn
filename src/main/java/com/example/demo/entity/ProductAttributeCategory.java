package com.example.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 产品属性分类表
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
public class ProductAttributeCategory extends Model<ProductAttributeCategory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.INPUT)
    private String id;

    private String name;
    /**
     * 属性数量
     */
    @TableField("attribute_count")
    private Integer attributeCount;
    /**
     * 参数数量
     */
    @TableField("param_count")
    private Integer paramCount;
    /**
     * 类型删除状态 0正常 1删除
     */
    @TableField("category_delete_flag")
    private String categoryDeleteFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(Integer attributeCount) {
        this.attributeCount = attributeCount;
    }

    public Integer getParamCount() {
        return paramCount;
    }

    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    public String getCategoryDeleteFlag() {
        return categoryDeleteFlag;
    }

    public void setCategoryDeleteFlag(String categoryDeleteFlag) {
        this.categoryDeleteFlag = categoryDeleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProductAttributeCategory{" +
        "id=" + id +
        ", name=" + name +
        ", attributeCount=" + attributeCount +
        ", paramCount=" + paramCount +
        ", categoryDeleteFlag=" + categoryDeleteFlag +
        "}";
    }
}
