package cn.licy.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // 打印异常信息
        System.out.println("登录失败：" + e.getMessage());
        httpServletResponse.sendRedirect(loginFailureUrl);
    }
}
