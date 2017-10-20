package com.p.ans.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public class OrderRequest {
    @NotNull(message = "用户编号未指定")
    private Integer uid;
    @NotNull(message = "商品编号未指定")
    private Long itemid;
    @NotNull()
    @Min(value = 1, message = "购买数量必须大于0")
    private Integer num;


    public OrderRequest(Integer uid, Long itemid, Integer num) {

        this.uid = uid;
        this.itemid = itemid;
        this.num = num;
    }

    public OrderRequest() {
    }

    @Override
    public String toString() {

        return "OrderRequest{" +
                "uid=" + uid +
                ", itemid=" + itemid +
                ", num=" + num +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public Long getItemid() {
        return itemid;
    }

    public Integer getNum() {
        return num;
    }
}
