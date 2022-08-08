package com.xxx.licy.jjwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * JWT单元测试
 *
 * @author lichenyang
 * @since 2022/8/8 11:17
 */
@SpringBootTest
public class JJwtTest {

    /**
     * 生成JWT
     */
    @Test
    public void testJwt() {
        JwtBuilder jwtBuilder = Jwts.builder()
                // 唯一ID {"jti", "888"}
                .setId("888")
                // 接受的用户 {"sub", "Rose"}
                .setSubject("Rose")
                // 签发时间 {"iat", "时间"}
                .setIssuedAt(new Date())
                // 签名算法以及秘钥
                .signWith(SignatureAlgorithm.HS256, "Rose");

        // 签发token
        String token = jwtBuilder.compact();
        System.out.println("token = " + token);

        System.out.println("-----------------------------------------------");

        String[] split = token.split("\\.");
        String jwtHeader = split[0];
        System.out.println("jwtHeader = " + Base64Codec.BASE64.decodeToString(jwtHeader));
        String jwtPayload = split[1];
        System.out.println("jwtPayload = " + Base64Codec.BASE64.decodeToString(jwtPayload));
        // 会乱码
        String jwtSignature = split[2];
        System.out.println("jwtSignature = " + Base64Codec.BASE64.decodeToString(jwtSignature));
    }
}
