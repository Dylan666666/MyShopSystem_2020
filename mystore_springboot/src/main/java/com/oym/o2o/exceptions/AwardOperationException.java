package com.oym.o2o.exceptions;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/8 21:55
 */
public class AwardOperationException extends RuntimeException {
    private static final long serialVersionUID = -4726629573930528450L;

    public AwardOperationException(String message) {
        super(message);
    }
}
