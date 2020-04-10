package com.oym.o2o.exceptions;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/25 13:30
 */
public class ShopCategoryOperationException extends RuntimeException {

    private static final long serialVersionUID = 712924720440806510L;

    public ShopCategoryOperationException(String message) {
        super(message);
    }
}
