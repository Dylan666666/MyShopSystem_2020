package com.oym.o2o.enums;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/8 15:47
 */
public enum UserAwardMapStateEnum {
    SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"), 
    NULL_USER_AWARD_ID(-1002, "UserAwardId为空"), 
    NULL_USER_AWARD_INFO(-1003, "传入了空的信息");

    private int state;

    private String stateInfo;

    UserAwardMapStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static UserAwardMapStateEnum stateOf(int index) {
        for (UserAwardMapStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
