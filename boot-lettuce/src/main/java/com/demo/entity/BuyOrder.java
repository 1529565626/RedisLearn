package com.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
public class BuyOrder extends Model<BuyOrder> {

    private static final long serialVersionUID = 1L;
    @TableId("id")
    private String id;
    @TableField("product_id")
    private String productId;

    private BigDecimal amount;


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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Order{" +
        ", id=" + id +
        ", productId=" + productId +
        ", amount=" + amount +
        "}";
    }
}
