package com.xxx.licy.security.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

/**
 * 自定义权限控制接口
 *
 * @author lichenyang
 * @since 2022/7/26 17:43
 */
public interface MyService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
