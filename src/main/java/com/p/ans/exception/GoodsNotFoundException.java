package com.p.ans.exception;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public class GoodsNotFoundException extends RuntimeException {
    public GoodsNotFoundException(String message) {
        super(message);
    }
}
