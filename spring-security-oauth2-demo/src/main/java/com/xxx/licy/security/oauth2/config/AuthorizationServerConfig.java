package com.xxx.licy.security.oauth2.config;

import com.xxx.licy.security.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;

/**
 * 授权服务器配置
 *
 * @author lichenyang
 * @since 2022/8/2 16:23
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserService userService;

    @Resource
    @Qualifier("jwtTokenStore")
    private TokenStore tokenStore;

    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 客户端ID
                .withClient("client")
                // 秘钥
                .secret(passwordEncoder.encode("112233"))
                // 重定向地址
                .redirectUris("https://www.baidu.com/")
                // 授权范围
                .scopes("all")
                // 授权模式：authorization_code(授权码模式)，password(密码模式)
                .authorizedGrantTypes("authorization_code","password");
    }

    /**
     * 密码模式
     *
     * @param endpoints endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                // accessToken转换成JwtToken
                .tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter);
    }
}
