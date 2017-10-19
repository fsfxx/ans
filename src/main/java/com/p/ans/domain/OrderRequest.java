package com.p.ans.domain;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public class OrderRequest {
    private Integer uid;
    private Long itemid;
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
