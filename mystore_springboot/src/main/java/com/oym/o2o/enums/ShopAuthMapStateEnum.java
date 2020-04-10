package com.oym.o2o.enums;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/5 21:36
 */
public enum ShopAuthMapStateEnum {
    SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"), NULL_SHOP_AUTH_ID(-1002,
            "ShopAuthId为空"), NULL_SHOP_AUTH_INFO(-1003, "传入了空的信息");

    private int state;
    private String stateInfo;

    ShopAuthMapStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ShopAuthMapStateEnum stateOf(int index) {
        for (ShopAuthMapStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
