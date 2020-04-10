package com.oym.o2o.dto;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/7 23:04
 * 迎合echart里的series项
 */
public class EchartSeries {
    private String name;
    private String type = "bar";
    private List<Integer> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }
}
