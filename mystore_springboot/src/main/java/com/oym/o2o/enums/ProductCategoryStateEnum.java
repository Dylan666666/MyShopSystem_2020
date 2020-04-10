package com.oym.o2o.enums;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/4 11:25
 */
public enum ProductCategoryStateEnum {
    SUCCESS(1,"创建成功"), 
    INNER_ERROR(-1001,"操作失败"), 
    EMPTY_LIST(-1002,"添加数少于1");
    
    ProductCategoryStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    
    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ProductCategoryStateEnum stateOf(int index) {
        for (ProductCategoryStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
