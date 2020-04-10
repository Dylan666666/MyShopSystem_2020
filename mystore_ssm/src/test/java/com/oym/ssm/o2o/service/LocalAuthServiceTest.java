package com.oym.ssm.o2o.service;

import com.oym.ssm.dto.LocalAuthExecution;
import com.oym.ssm.entity.LocalAuth;
import com.oym.ssm.o2o.BaseTest;
import com.oym.ssm.service.LocalAuthService;
import com.oym.ssm.utils.MD5;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/26 10:45
 */
public class LocalAuthServiceTest extends BaseTest {
    @Autowired
    LocalAuthService localAuthService;

    @Test
    public void testModifyLocalAuth() {
        LocalAuthExecution localAuthExecution = localAuthService.modifyLocalAuth(1L,"123456","777777","123456");
        System.out.println(localAuthExecution.getStateInfo());
    }
    
    @Test
    public void testGetLocalAuthByUsernameAndPwd() {
        LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd("123456", MD5.getMd5("123456"));
        System.out.println(localAuth.getUsername());
    }
    
}
