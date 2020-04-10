package com.oym.ssm.exceptions;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/5 10:55
 */
public class ProductCategoryOperationException extends RuntimeException {

    private static final long serialVersionUID = -7138618824330332868L;

    public ProductCategoryOperationException(String msg) {
        super(msg);
    }
}
