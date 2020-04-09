package com.example.demo.util;


import com.baomidou.mybatisplus.plugins.Page;

import java.beans.Transient;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分页辅助实体类工具
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @author Zhang@Jowim.com
 * @version V1.1
 * @date 2018年07月11日 18:58
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
public class PageUtil<T> extends Page<T> {
    private static final long serialVersionUID = 1L;
    /**
     * 查询内容
     */
    private List<T> records;
    /**
     * 映射
     */
    private Map<String, Object> condition;

    /**
     * 无条件分页查询
     *
     * @param current 页数
     * @param size    每页显示数量
     */
    public PageUtil(int current, int size) {
        super(current == 0 ? 1 : current, size == 0 ? 10 : size);
        this.records = Collections.emptyList();
    }

    /**
     * 条件分页查询
     *
     * @param current      页数
     * @param size         每页显示数量
     * @param orderByField 条件
     */
    private PageUtil(int current, int size, String orderByField) {
        super(current == 0 ? 1 : current, size == 0 ? 10 : size);
        this.records = Collections.emptyList();
        this.setOrderByField(orderByField);
    }

    /**
     * 条件分页查询
     *
     * @param current      页数
     * @param size         每页显示数量
     * @param orderByField 条件
     * @param isAsc        正序 倒序
     */
    public PageUtil(int current, int size, String orderByField, boolean isAsc) {
        this(current, size, orderByField);
        this.setAsc(isAsc);
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public PageUtil<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    @Transient
    public Map<String, Object> getCondition() {
        return this.condition;
    }

    @Override
    public PageUtil<T> setCondition(Map<String, Object> condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder pg = new StringBuilder();
        pg.append(" Page:{ [").append(super.toString()).append("], ");
        if (this.records != null) {
            pg.append("records-size:").append(this.records.size());
        } else {
            pg.append("records is null");
        }

        return pg.append(" }").toString();
    }
}
