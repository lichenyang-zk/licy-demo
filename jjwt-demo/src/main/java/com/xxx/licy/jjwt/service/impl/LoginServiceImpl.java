package com.xxx.licy.jjwt.service.impl;

import com.xxx.licy.jjwt.constanst.JwtClaimsConstant;
import com.xxx.licy.jjwt.service.LoginService;
import com.xxx.licy.jjwt.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private String token;
    @Value("${jwt.is-custom-key}")
    private Boolean isCustomKey;
    @Value("${jwt.custom-secret-key}")
    private String customKey;

    @Override
    public String login(String username) {
        SecretKey secretKey;
        if (isCustomKey) {
            // 自定义密钥（自定义必须满足base64编码后字节长度>=256 bits）
            secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(customKey));
        } else {
            // 生成密钥
            secretKey = Jwts.SIG.HS256.key().build();
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, "000");
        claims.put(JwtClaimsConstant.USERNAME, username);
        String token = JwtUtils.createJwt(secretKey, 1000, claims);
        this.token = token;
        return token;
    }

    @Override
    public String hello(String token) {
        if (StringUtils.isBlank(token)) {
            return "未登录";
        }
        if (!token.equals(this.token)) {
            return "未登录";
        }
        SecretKey secretKey;
        if (isCustomKey) {
            // 自定义密钥（自定义必须满足base64编码后字节长度>=256 bits）
            secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(customKey));
        } else {
            // 生成密钥
            secretKey = Jwts.SIG.HS256.key().build();
        }
        Claims claims = JwtUtils.parseJWT(secretKey, token);
        String username = (String) claims.get(JwtClaimsConstant.USERNAME);
        return "Hello " + username;
    }
}
