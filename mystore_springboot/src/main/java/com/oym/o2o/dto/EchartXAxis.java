package com.oym.o2o.dto;

import java.util.HashSet;

/**
 * 迎合echart里的xAxis项
 * @Author: Mr_OO
 * @Date: 2020/4/7 22:55
 */
public class EchartXAxis {
    private String type = "category";
    /**
     * 为了去重
     */
    private HashSet<String> data;

    public HashSet<String> getData() {
        return data;
    }

    public void setData(HashSet<String> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }
}
