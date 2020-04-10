package com.oym.ssm.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/23 10:00
 * 用来配置 spring和 junit整合，junit启动时加载 springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-redis.xml"})
public class BaseTest {
    
}
