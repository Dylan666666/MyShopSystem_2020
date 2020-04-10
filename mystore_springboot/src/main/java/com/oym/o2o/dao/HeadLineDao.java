package com.oym.o2o.dao;

import com.oym.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/13 15:45
 */
public interface HeadLineDao {
    /**
     * 根据传入的查询条件(头条名查询头条)
     * @param headLineCondition
     * @return
     */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
