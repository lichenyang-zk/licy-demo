package cn.xxx.licy.security.service.impl;

import cn.xxx.licy.security.service.MyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * 自定义权限控制
 *
 * @author lichenyang
 * @since 2022/7/26 17:45
 */
@Service
public class MyServiceImpl implements MyService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 获取主体
        Object principal = authentication.getPrincipal();
        // 判断主体是否属于UserDetails
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            // 获取权限
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            // 判断请求的URI是否在权限列表里
            return authorities.contains(new SimpleGrantedAuthority(request.getRequestURI()));
        }
        return false;
    }
}
