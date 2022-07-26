package cn.licy.security.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义异常处理器
 *
 * @author lichenyang
 * @since 2022/7/22 18:18
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        // 响应状态
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // 响应头
        httpServletResponse.setHeader("Content-Type","application/json;charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write("{\"status\":\"error\",\"msg\":\"权限不足，返回\"}");
    }
}
