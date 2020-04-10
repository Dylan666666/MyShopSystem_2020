package com.oym.o2o.exceptions;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/9 11:58
 */
public class PersonInfoOperationException extends RuntimeException {
    private static final long serialVersionUID = -1998403383565808367L;

    public PersonInfoOperationException(String message) {
        super(message);
    }
}
