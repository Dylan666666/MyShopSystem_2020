package com.oym.ssm.o2o.dao;

import com.oym.ssm.dao.LocalAuthDao;
import com.oym.ssm.entity.LocalAuth;
import com.oym.ssm.entity.PersonInfo;
import com.oym.ssm.o2o.BaseTest;
import com.oym.ssm.utils.MD5;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/25 16:31
 */
public class LocalAuthDaoTest extends BaseTest {
    @Autowired
    private LocalAuthDao localAuthDao;
    private static final String USERNAME = "666666";
    private static final String PASSWORD = "666666";

    @Test
    public void testInsertLocalAuth() throws Exception {
        //新增一条平台账户信息
        LocalAuth localAuth = new LocalAuth();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        //给平台账号绑定上用户信息
        localAuth.setPersonInfo(personInfo);
        //设置上用户名和密码
        localAuth.setUsername(USERNAME);
        localAuth.setPassword(MD5.getMd5(PASSWORD));
        localAuth.setCreateTime(new Date());
        int effectedNum = localAuthDao.insertLocalAuth(localAuth);
        System.out.println("添加用户账号结果为："  + effectedNum);
    }
    
    @Test
    public void testQueryLocalByUserNameAndPwd() throws Exception {
        //按照账号和密码查询用户信息
        LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(USERNAME,MD5.getMd5(PASSWORD));
        System.out.println(localAuth.getUsername());
    }

    @Test
    public void testQueryLocalById() throws Exception {
        //按照账号和密码查询用户信息
        LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
        System.out.println(localAuth.getUsername());
    }

    @Test
    public void testUpdateLocalAuth() throws Exception {
        //依据用户 ID ,平台账号，以及旧密码修改平台账号密码
        Date nowDate = new Date();
        int effectedNum = localAuthDao.updateLocalAuth(1L,USERNAME,PASSWORD,PASSWORD,nowDate);
        System.out.println("更新情况为：" + effectedNum);
    }
    
}
