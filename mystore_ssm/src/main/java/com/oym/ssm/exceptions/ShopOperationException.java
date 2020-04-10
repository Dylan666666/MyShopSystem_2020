package com.oym.ssm.exceptions;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/25 14:49
 */
public class ShopOperationException extends RuntimeException {
    private static final long serialVersionUID = 2361446884822298905L;
    
    public ShopOperationException(String msg) {
        super(msg);
    }
}
