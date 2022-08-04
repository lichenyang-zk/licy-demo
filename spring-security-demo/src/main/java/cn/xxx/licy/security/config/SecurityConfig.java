package cn.xxx.licy.security.config;

import cn.xxx.licy.security.handler.MyAccessDeniedHandler;
import cn.xxx.licy.security.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Security 配置类
 *
 * @author lichenyang
 * @since 2022/7/11 17:51
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private DataSource dataSource;

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Resource
    private PersistentTokenRepository persistentTokenRepository;

    @Bean
    public PasswordEncoder getPasswordEncoding() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 设置数据源
        jdbcTokenRepository.setDataSource(dataSource);
        // 自定建表，第一次启动建表，然后注释掉
        // jdbcTokenRepository.setCreateTableOnStartup(true);

        return jdbcTokenRepository;
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
                .successForwardUrl("/toMain")
                // 自定义登录成功处理器
                // .successHandler(new MyAuthenticationSuccessHandler())
                // 登录失败后跳转的页面
                .failureForwardUrl("/toError");
        // 自定义登录失败处理器
        // .failureHandler(new MyAuthenticationFailureHandler());

        // 授权
        http.authorizeRequests()
                // 放行login.html，不需要认证
                .antMatchers("/login.html").permitAll()
                // 放行login.html，不需要认证，access方式
                // .antMatchers("/login.html").access("permitAll")
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
                // .antMatchers("/security.html").hasIpAddress("127.0.0.1")
                // 基于IP控制，，access方式
                // .antMatchers("/security.html").access("hasIpAddress('127.0.0.1')")
                // 自定义权限控制
                // .anyRequest().access("@myServiceImpl.hasPermission(request, authentication)");
                // 除上面放行的之外，所有的请求都必须认证才能访问
                .anyRequest().authenticated();


        // 自定义异常处理器
        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler());

        // 记住我
        http.rememberMe()
                .tokenRepository(persistentTokenRepository)
                // 自定义参数名，默认为remember-me
                // .rememberMeParameter("")
                // 超时时间，默认两周，暂设置60秒
                .tokenValiditySeconds(60)
                // 自定义登录逻辑
                .userDetailsService(userDetailsService);

        // 关闭csrf防护
        http.csrf().disable();
    }
}
