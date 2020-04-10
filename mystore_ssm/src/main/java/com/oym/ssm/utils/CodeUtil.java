package com.oym.ssm.utils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/27 19:33
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        String verifyCodeExpected = (String)request.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if (verifyCodeActual == null || !verifyCodeExpected.equalsIgnoreCase(verifyCodeActual)) {
            return false;
        }
        return true;
    }
}
