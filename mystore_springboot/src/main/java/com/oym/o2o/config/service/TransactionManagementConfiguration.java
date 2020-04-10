package com.oym.o2o.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @EnableTransactionManagement 开启事务支持，在Service方法上添加注解 @Transactional即可
 * @Author: Mr_OO
 * @Date: 2020/3/30 19:41
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {
    /**
     * 注入DataSourceConfiguration里边的dataSource,通过createDataSource()获取
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 关于事务管理，需要返回PlatformTransactionManager的实现
     * @return
     */
    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
