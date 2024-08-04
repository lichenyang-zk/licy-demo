package com.xxx.licy.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * 登录失败处理器
 *
 * @author lichenyang
 * @since 2022/7/12 14:16
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private String loginFailureUrl = "/error.html";

    public MyAuthenticationFailureHandler() {
    }

    public MyAuthenticationFailureHandler(String loginFailureUrl) {
        this.loginFailureUrl = loginFailureUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 打印异常信息
        System.out.println("登录失败：" + exception.getMessage());
        response.sendRedirect(loginFailureUrl);
    }
}
