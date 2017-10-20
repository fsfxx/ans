package com.p.ans.domain;

import javax.persistence.*;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(targetEntity = Goods.class)
    @JoinColumn(name = "goods_id")
    private Goods goods;
    private Integer quantity;

    public Order() {
    }

    public Order(User user, Goods goods, Integer quantity) {

        this.user = user;
        this.goods = goods;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Goods getGoods() {
        return goods;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", goods=" + goods +
                ", quantity=" + quantity +
                '}';
    }
}
