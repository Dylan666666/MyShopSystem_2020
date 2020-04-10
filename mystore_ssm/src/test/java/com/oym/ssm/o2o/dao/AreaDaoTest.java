package com.oym.ssm.o2o.dao;

import com.oym.ssm.dao.AreaDao;
import com.oym.ssm.entity.Area;
import com.oym.ssm.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/23 10:00
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;
    
    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        System.out.println(2 == areaList.size());
    }
}
