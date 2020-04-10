package com.oym.ssm.o2o.dao;

import com.oym.ssm.dao.HeadLineDao;
import com.oym.ssm.entity.HeadLine;
import com.oym.ssm.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/13 16:09
 */
public class HeadLineDaoTest extends BaseTest {
    @Autowired
    private HeadLineDao headLineDao;
    
    @Test
    public void testQueryArea() {
        List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
        System.out.println("获得头条数：" + headLineList.size());
    }
    
    
}
