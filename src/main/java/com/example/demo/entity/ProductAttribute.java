package com.example.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 商品属性参数表
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-20
 */
public class ProductAttribute extends Model<ProductAttribute> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.INPUT)
    private String id;

    /**
     * 商品属性类型id
     */
    private String productAttributeCategoryId;

    /**
     * 属性名
     */
    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     */
    private String selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    private String inputType;

    /**
     * 可选值列表，以逗号隔开
     */
    private String inputList;

    /**
     * 排序字段：最高的可以单独上传图片
     */
    private Integer sort;

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    private String filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    private String searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    private String relatedStatus;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    private String handAddStatus;

    /**
     * 属性的类型；0->规格；1->参数
     */
    private String type;

    /**
     * 属性的删除状态；0->未删除；1->删除
     */
    private String attributeDeleteFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(String productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(String relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public String getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(String handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttributeDeleteFlag() {
        return attributeDeleteFlag;
    }

    public void setAttributeDeleteFlag(String attributeDeleteFlag) {
        this.attributeDeleteFlag = attributeDeleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProductAttribute{" +
        "id=" + id +
        ", productAttributeCategoryId=" + productAttributeCategoryId +
        ", name=" + name +
        ", selectType=" + selectType +
        ", inputType=" + inputType +
        ", inputList=" + inputList +
        ", sort=" + sort +
        ", filterType=" + filterType +
        ", searchType=" + searchType +
        ", relatedStatus=" + relatedStatus +
        ", handAddStatus=" + handAddStatus +
        ", type=" + type +
        ", attributeDeleteFlag=" + attributeDeleteFlag +
        "}";
    }
}
