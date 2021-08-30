package com.example.variousdemo.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.variousdemo.config.JwtConfig;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;

/**
 * @className: TokenInterceptor
 * @description: 配置拦截器
 * @created: 2021/08/27 15:11
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //地址过滤
        String uri = request.getRequestURI();
        if(uri.contains("/login")){
            return true;
        }
        //Token验证
        String token = request.getHeader(jwtConfig.getHeader());
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(jwtConfig.getHeader());
        }
        if(StringUtils.isEmpty(token)){
            throw new SignatureException(jwtConfig.getHeader() + "不能为空");
        }

        Claims claims = null;
        try{
            claims = jwtConfig.getTokenClaim(token);
            if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
                throw new SignatureException(jwtConfig.getHeader() + "失效,请重新登录");
            }
        } catch (Exception e){
            throw new SignatureException(jwtConfig.getHeader() + "失效,请重新登录");
        }

        //设置identityId用户身份ID
        request.setAttribute("identityId",claims.getSubject());
        return true;
    }
}
