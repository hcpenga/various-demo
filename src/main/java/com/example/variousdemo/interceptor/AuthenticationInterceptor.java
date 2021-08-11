package com.example.variousdemo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: AuthenticationInterceptor
 * @description:
 * @created: 2021/08/11 10:26
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {


//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
//        System.out.println("preHandle方法:进来了");
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest,
//                           HttpServletResponse httpServletResponse,
//                           Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle方法:进来了");
//    }
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest,
//                                HttpServletResponse httpServletResponse,
//                                Object o, Exception e) throws Exception {
//        System.out.println("afterCompletion方法:进来了");
//    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法:进来了");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法:进来了");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion方法:进来了");

    }
}
