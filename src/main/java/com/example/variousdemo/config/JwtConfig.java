package com.example.variousdemo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @className: JwtConfig
 * @description:
 * @created: 2021/08/27 14:39
 */
@ConfigurationProperties(prefix = "config.jwt")
@Component
public class JwtConfig {

    private String secret;
    private long expire;
    private String header;

    /**
     * 功能描述：
     * 〈生成token〉
     * @Date: 14:46 2021/8/27 0027
     * @param subject
     * @return: java.lang.String
     **/
    public String createToken(String subject){
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 功能描述：
     * 〈获取token中注册信息〉
     * @Date: 14:48 2021/8/27 0027
     * @param token
     * @return: io.jsonwebtoken.Claims
     **/
    public Claims getTokenClaim(String token){
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 功能描述：
     * 〈验证token是否过期失效〉
     * @Date: 14:51 2021/8/27 0027
     * @param expirationTime
     * @return: boolean
     **/
    public boolean isTokenExpired(Date expirationTime){
        return expirationTime.before(new Date());
    }

    /**
     * 功能描述：
     * 〈获取token失效时间〉
     * @Date: 14:53 2021/8/27 0027
     * @param token
     * @return: java.util.Date
     **/
    public Date getExpirationDateFromToken(String token){
        return getTokenClaim(token).getExpiration();
    }

    /**
     * 功能描述：
     * 〈获取用户名从token〉
     * @Date: 14:55 2021/8/27 0027
     * @param token
     * @return: java.lang.String
     **/
    public String getUsernameFromToken(String token){
        return getTokenClaim(token).getSubject();
    }

    /**
     * 功能描述：
     * 〈获取jwt发布时间〉
     * @Date: 14:56 2021/8/27 0027
     * @param token
     * @return: java.util.Date
     **/
    public Date getIssuedAtDateFromToken(String token){
        return getTokenClaim(token).getIssuedAt();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
