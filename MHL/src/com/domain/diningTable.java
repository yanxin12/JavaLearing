// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 12:57
 * IDE: IntelliJ IDEA
 * Introduction:
 * This is a POJO connectied with the table diningTable in database MHL
 * id INT PRIMARY KEY AUTO_INCREMENT, #自增, 表示餐桌编号
 * state VARCHAR(20) NOT NULL DEFAULT '',#餐桌的状态
 * orderName VARCHAR(50) NOT NULL DEFAULT '',#预订人的名字
 * orderTel VARCHAR(20) NOT NULL DEFAULT ''
 */
package com.domain;

public class diningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public diningTable() {
    }

    public diningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + state + "\t\t" + orderName + "\t\t" + orderTel;
    }
}
