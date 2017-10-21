package com.p.ans.exception;

/**
 * Created by Xunxiao Ren on 2017/10/21.
 */
public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
