package com.p.ans.exception;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
