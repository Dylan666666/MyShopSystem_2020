package com.oym.ssm.exceptions;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/6 16:21
 */
public class ProductOperationException extends RuntimeException{
    private static final long serialVersionUID = -5032668604862932182L;

    public ProductOperationException(String message) {
        super(message);
    }
}
