package com.softnovo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`order`")
//@Proxy(lazy = false)
public class JpaOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String deliveryAddress;
    @ManyToMany(targetEntity=JpaGoods.class)
    @JoinTable(name = "order_goods", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id"))
    private List<JpaGoods> goods = new ArrayList<>();

    @Override
    public String toString() {
        return "JpaOrder{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", goods=" + goods +
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

    public List<JpaGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<JpaGoods> goods) {
        this.goods = goods;
    }
}
