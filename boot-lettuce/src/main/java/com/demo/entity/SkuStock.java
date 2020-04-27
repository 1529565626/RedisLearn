package com.demo.entity;

import java.io.Serializable;

/**
 * @author Martin_W
 * @date 2020/4/24 0024 9:53
 */
public class SkuStock implements Serializable {
    private String id;
    private Long stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
