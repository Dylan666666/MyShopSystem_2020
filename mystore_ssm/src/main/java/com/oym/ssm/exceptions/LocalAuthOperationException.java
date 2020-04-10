package com.oym.ssm.exceptions;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/26 10:11
 */
public class LocalAuthOperationException extends RuntimeException {

    private static final long serialVersionUID = -6222161796720816827L;

    public LocalAuthOperationException(String message) {
        super(message);
    }
}
