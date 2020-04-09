package com.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Martin_W
 * @date 2020/4/8 0008 17:13
 */
@Data
public class User implements Serializable {

    private  String id;

    private String name;

    private Integer age;

}
