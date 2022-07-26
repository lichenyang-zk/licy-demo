package cn.licy.security.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserDetailService 实现类
 *
 * @author lichenyang
 * @since 2022/7/11 17:54
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名去查询数据库，这里模拟用户admin
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 密码比较，若匹配成功则返回UserDetails，这里为模拟不比较，直接返回
        String password = passwordEncoder.encode("123");
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc,/main.html"));
    }
}
