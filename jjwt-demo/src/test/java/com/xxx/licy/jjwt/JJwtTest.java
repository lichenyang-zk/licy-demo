package com.xxx.licy.jjwt;

import com.xxx.licy.jjwt.constanst.JwtClaimsConstant;
import com.xxx.licy.jjwt.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

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
        String customKey = "7D0BB9B4C934433481C35FA0622BE7B947CED8DD00E7481F99353700FC480C6134BCD0F4C8264B6" +
                "EB14E1932610777552D82E0FD331B4D528C3A35FA0743A390";
        // 自定义密钥（自定义必须满足base64编码后字节长度>=256 bits）
        // SecretKey customSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(customKey));
        // 生成密钥
        SecretKey generateSecretKey = Jwts.SIG.HS256.key().build();
        // 模拟登陆生成，返回给客户端
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, "001");
        claims.put(JwtClaimsConstant.USERNAME, "licy");
        String token = JwtUtils.createJwt(generateSecretKey, 1000, claims);

        System.out.println("token = " + token);

        System.out.println("-----------------------------------------------");

        // 需要创建一个jwt拦截器，注册到WebMvcConfiguration配置类中
        Claims claims01 = JwtUtils.parseJWT(generateSecretKey, token);
        // claims就是在Payload中存放的用户信息
        System.out.println(JwtClaimsConstant.USERNAME + " = " + claims01.get(JwtClaimsConstant.USERNAME));
    }
}
