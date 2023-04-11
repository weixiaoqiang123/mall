package com.wxq.mall.utils;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public class JwtUtil {

    private final static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    public static String createToken(String userId, int time) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Calendar expireTime = Calendar.getInstance();
        expireTime.add(Calendar.SECOND, time);
        //生成签名密钥
        byte[] apiKeySecretBytes = Base64.getDecoder().decode(base64Secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                //设置字符串过期时间
                .setExpiration(expireTime.getTime())
                //私有部分
                .claim("userId", userId)
                //设置秘钥
                .signWith(signatureAlgorithm, signingKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    /**
     * 判断token是否存在与有效
     * @param token
     * @return
     */
    public static void verify(String token) throws ExpiredJwtException {
        Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret)).parseClaimsJws(token);
    }

    /**
     * 获取用户id
     *
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Claims claims = parseJWT(token);
        if (null != claims) {
            return (String) claims.get("userId");
        }
        return null;
    }

    private static Claims parseJWT(String jsonWebToken) {
        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(jsonWebToken).getBody();
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        // 生成token 30s过期
        String token = createToken("weixiaoqiang", 30);
        System.out.println(token);
    }
}
