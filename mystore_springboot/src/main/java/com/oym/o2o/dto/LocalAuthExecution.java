package com.oym.o2o.dto;

import com.oym.o2o.entity.LocalAuth;
import com.oym.o2o.enums.LocalAuthStateEnum;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/26 10:11
 */
public class LocalAuthExecution {
    private int state;
    private int count;
    private String stateInfo;
    private LocalAuth localAuth;
    private List<LocalAuth> localAuthList;
    
    public LocalAuthExecution (LocalAuthStateEnum localAuthStateEnum) {
        this.state = localAuthStateEnum.getState();
        this.stateInfo = localAuthStateEnum.getStateInfo();
    }

    public LocalAuthExecution (LocalAuthStateEnum localAuthStateEnum,LocalAuth localAuth) {
        this.state = localAuthStateEnum.getState();
        this.stateInfo = localAuthStateEnum.getStateInfo();
        this.localAuth = localAuth;
    }

    public LocalAuthExecution (LocalAuthStateEnum localAuthStateEnum,List<LocalAuth> localAuthList) {
        this.state = localAuthStateEnum.getState();
        this.stateInfo = localAuthStateEnum.getStateInfo();
        this.localAuthList = localAuthList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public LocalAuth getLocalAuth() {
        return localAuth;
    }

    public void setLocalAuth(LocalAuth localAuth) {
        this.localAuth = localAuth;
    }

    public List<LocalAuth> getLocalAuthList() {
        return localAuthList;
    }

    public void setLocalAuthList(List<LocalAuth> localAuthList) {
        this.localAuthList = localAuthList;
    }
}
