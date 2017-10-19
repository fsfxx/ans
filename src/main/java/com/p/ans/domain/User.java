package com.p.ans.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer money;

    public User(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
