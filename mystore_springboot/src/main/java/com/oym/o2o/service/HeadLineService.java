package com.oym.o2o.service;

import com.oym.o2o.entity.HeadLine;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/13 16:33
 */
public interface HeadLineService {
    public final static String HEAD_LIST_KEY = "headlinelist";
    
    /**
     * 根据传入的条件返回指定的头条列表
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
