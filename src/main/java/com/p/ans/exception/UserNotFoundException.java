package com.p.ans.exception;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
