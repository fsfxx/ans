package com.p.ans.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */

@Entity
public class Goods {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer quantity;
    private Integer price;

    public Goods(String name, Integer quantity, Integer price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Goods() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
