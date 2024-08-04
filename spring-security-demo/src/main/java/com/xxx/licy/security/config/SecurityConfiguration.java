package com.xxx.licy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.method.AuthorizationManagerBeforeMethodInterceptor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestMatcherDelegatingAuthorizationManager;

/**
 * Security配置
 *
 * @author lichenyang
 * @since 2024/8/4 20:01
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry
                    // 放行login.html，不需要认证
                    .requestMatchers("/login.html").permitAll()
                    // 放行login.html，不需要认证，access方式，暂不清楚
                    // .requestMatchers("/login.html").access("permitAll")
                    // 放行error.html，不需要认证
                    // .requestMatchers("/error.html").permitAll()
                    // 放行所有静态资源
                    // .requestMatchers("/images/**").permitAll()
                    // 放行jpg格式的图片
                    // .requestMatchers("/**/*.jpg").permitAll()
                    // 放行jpg格式的图片，正则表达式
                    // .regexMatchers(".+[.]jpg").permitAll()
                    // 指定请求放行
                    // .regexMatchers(HttpMethod.POST,"/demo").permitAll()
                    // .regexMatchers("/security/demo").permitAll()
                    // mvc匹配
                    // .mvcMatchers("/demo").servletPath("/security").permitAll()
                    // .requestMatchers("/security/demo").permitAll()
                    // 权限控制，hasAuthority严格区分大小写
                    // .requestMatchers("/security.html").hasAuthority("Admin")
                    // .requestMatchers("/security.html").hasAnyAuthority("admin", "Admin")
                    // 基于角色控制，hasRole严格区分大小写，且角色前不能加ROLE_，会报错
                    // .requestMatchers("/security.html").hasRole("Admin")
                    // .requestMatchers("/security.html").hasAnyRole("admin", "Admin")
                    // 基于IP控制，暂不支持
                    // .requestMatchers("/security.html").has("127.0.0.1")
                    // 基于IP控制，，access方式，暂不清楚
                    // .requestMatchers("/security.html").access("hasIpAddress('127.0.0.1')")
                    // 自定义权限控制，暂不清楚
                    // .anyRequest().access("@myServiceImpl.hasPermission(request, authentication)");
                    // 除上面放行的之外，所有的请求都必须认证才能访问
                    .anyRequest().authenticated();
        });
        return http.build();
    }

    private RequestMatcherDelegatingAuthorizationManager getManager(){
        return null;
    }
}
