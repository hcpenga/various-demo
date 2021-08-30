//package com.example.variousdemo.config;
//
//import com.example.variousdemo.interceptor.TokenInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @className: WebConfig
// * @description: 注册拦截器到SpringMVC
// * @created: 2021/08/30 09:13
// */
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private TokenInterceptor tokenInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");//这个方法是表示拦截那些方法，/**表示拦截所有的Controller;
////                .excludePathPatterns(//这个方法是表示那些方法不需要拦截  /*表示该根下的方法，/**表示该下的所有方法
////                        "/leaming/dialog/*",
////                        "/static/**",
////                        "/TextController/userLogin",
////                        "/TextController/registerUser",
////                        "/TextController/existsUser",
////                        "/TextController/createImg"
////                );
//    }
//}
