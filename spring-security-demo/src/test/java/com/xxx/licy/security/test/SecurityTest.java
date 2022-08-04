package com.xxx.licy.security.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 测试
 *
 * @author lichenyang
 * @since 2022/7/11 17:31
 */
@SpringBootTest
public class SecurityTest {

    @Test
    public void testPasswordEncoding() {
        // 密码
        String password = "123";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encode = passwordEncoder.encode(password);
        System.out.println("加密前：" + password);
        System.out.println("加密后：" + encode);
        // 密码比较
        boolean matches = passwordEncoder.matches("123", encode);
        System.out.println("密码匹配：" + matches);
    }
}
