package cn.licy.security.config;

import cn.licy.security.handler.MyAccessDeniedHandler;
import cn.licy.security.handler.MyAuthenticationFailureHandler;
import cn.licy.security.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security 配置类
 *
 * @author lichenyang
 * @since 2022/7/11 17:51
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoding() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单提交
        http.formLogin()
                // 自定义表单参数
                // .usernameParameter("username123")
                // .passwordParameter("password123")
                // 自定义登录页面
                .loginPage("/login.html")
                // 必须和表单提交的接口保持一致，才会去执行自定义登录逻辑
                .loginProcessingUrl("/login")
                // 登录成功后跳转的页面，POST请求
                // .successForwardUrl("/toMain")
                // 自定义登录成功处理器
                .successHandler(new MyAuthenticationSuccessHandler())
                // 登录失败后跳转的页面
                // .failureForwardUrl("/toError")
                // 自定义登录失败处理器
                .failureHandler(new MyAuthenticationFailureHandler());

        // 授权
        http.authorizeRequests()
                // 放行login.html，不需要认证
                .antMatchers("/login.html").permitAll()
                // 放行error.html，不需要认证
                .antMatchers("/error.html").permitAll()
                // 放行所有静态资源
                // .antMatchers("/images/**").permitAll()
                // 放行jpg格式的图片
                // .antMatchers("/**/*.jpg").permitAll()
                // 放行jpg格式的图片，正则表达式
                // .regexMatchers(".+[.]jpg").permitAll()
                // 指定请求放行
                // .regexMatchers(HttpMethod.POST,"/demo").permitAll()
                // .regexMatchers("/security/demo").permitAll()
                // mvc匹配
                // .mvcMatchers("/demo").servletPath("/security").permitAll()
                // .antMatchers("/security/demo").permitAll()
                // 权限控制，hasAuthority严格区分大小写
                // .antMatchers("/security.html").hasAuthority("Admin")
                // .antMatchers("/security.html").hasAnyAuthority("admin","Admin")
                // 基于角色控制，hasRole严格区分大小写，且角色前不能加ROLE_，会报错
                // .antMatchers("/security.html").hasRole("Admin")
                // .antMatchers("/security.html").hasAnyRole("admin", "Admin")
                // 基于IP控制
                .antMatchers("/security.html").hasIpAddress("127.0.0.1")
                // 除上面放行的之外，所有的请求都必须认证才能访问
                .anyRequest().authenticated();

        // 自定义异常处理器
        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler());

        // 关闭csrf防护
        http.csrf().disable();
    }
}
