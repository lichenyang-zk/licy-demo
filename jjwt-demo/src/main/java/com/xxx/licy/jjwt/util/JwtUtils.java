package com.xxx.licy.jjwt.util;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    /**
     * 生成jwt
     *
     * @param secretKey jwt秘钥
     * @param ttlMillis jwt过期时间(秒)
     * @param claims    设置的信息
     * @return 加密数据
     */
    public static String createJwt(SecretKey secretKey, long ttlMillis, Map<String, Object> claims) {

        // 有效期
        long expMillis = System.currentTimeMillis() + (ttlMillis * 1000);
        Date expDate = new Date(expMillis);

        // 生成Jwt令牌
        JwtBuilder builder = Jwts.builder()
                // 自定义内容
                .claims(claims)
                // 设置过期时间
                .expiration(expDate)
                // 秘钥
                .signWith(secretKey);

        return builder.compact();
    }

    /**
     * Token解密
     *
     * @param secretKey jwt秘钥
     * @param token     加密后的token
     * @return 解密数据
     */
    public static Claims parseJWT(SecretKey secretKey, String token) {
        // 得到DefaultJwtParser
        JwtParser jwtParser = Jwts.parser()
                // 设置签名的秘钥
                .verifyWith(secretKey)
                .build();
        Jws<Claims> jws = jwtParser.parseSignedClaims(token);
        return jws.getPayload();
    }
}
