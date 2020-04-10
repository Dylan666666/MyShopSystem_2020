package com.oym.o2o.service;

import com.oym.o2o.dto.LocalAuthExecution;
import com.oym.o2o.entity.LocalAuth;
import com.oym.o2o.exceptions.LocalAuthOperationException;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/26 10:07
 */
public interface LocalAuthService {
    /**
     * 通过帐号和密码获取平台帐号信息
     * @param userName
     * @param password
     * @return
     */
    LocalAuth getLocalAuthByUsernameAndPwd(String userName, String password);

    /**
     * 通过userId获取平台帐号信息
     * @param userId
     * @return
     */
    LocalAuth getLocalAuthByUserId(long userId);

    /**
     * 绑定微信，生成平台专属的帐号
     * @param localAuth
     * @return
     * @throws LocalAuthOperationException
     */
    LocalAuthExecution bindLocalAuth(LocalAuth localAuth) throws LocalAuthOperationException;

    /**
     *修改平台帐号的登录密码
     * @param userId
     * @param userName
     * @param password
     * @param newPassword
     * @return
     * @throws LocalAuthOperationException
     */
    LocalAuthExecution modifyLocalAuth(Long userId, String userName, String password, String newPassword)
            throws LocalAuthOperationException;
}
