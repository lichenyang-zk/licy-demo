package com.xxx.licy.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

/**
 * 登陆成功处理器
 *
 * @author lichenyang
 * @since 2022/7/12 11:23
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String loginSuccessUrl = "/main.html";

    public MyAuthenticationSuccessHandler() {
    }

    public MyAuthenticationSuccessHandler(String loginSuccessUrl) {
        this.loginSuccessUrl = loginSuccessUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 获取当前登录用户,打印当前用户信息，以作演示
        User user = (User) authentication.getPrincipal();
        System.out.println("user.getUsername() = " + user.getUsername());
        // 密码会显示null
        System.out.println("user.getPassword() = " + user.getPassword());
        System.out.println("user.getAuthorities() = " + user.getAuthorities());
        response.sendRedirect(loginSuccessUrl);
    }
}
