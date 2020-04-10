package com.oym.o2o.enums;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/8 15:22
 */
public enum UserShopMapStateEnum {
    SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"),
    NULL_USER_SHOP_ID(-1002, "UserShopId为空"), 
    NULL_USER_SHOP_INFO(-1003, "传入了空的信息");

    private int state;

    private String stateInfo;

    UserShopMapStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static UserShopMapStateEnum stateOf(int index) {
        for (UserShopMapStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
