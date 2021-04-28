package com.softnovo.domain;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private Long id; //订单Id
    private String orderNumber; //订单编号
    private String deliveryAddress; //物流地址
    private List<Goods> goodsList = Lists.newArrayList();

    public Order(long id, String orderNumber, String deliveryAddress) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
