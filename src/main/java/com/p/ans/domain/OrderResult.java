package com.p.ans.domain;

import java.util.Date;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public class OrderResult {
    private Boolean success;
    private String msg;
    private Date time;

    public OrderResult(Boolean success, String msg, Date time) {
        this.success = success;
        this.msg = msg;
        this.time = time;
    }

    public OrderResult() {
    }

    public OrderResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
        this.time = new Date();
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", time=" + time +
                '}';
    }

    public Date getTime() {
        return time;
    }
}
