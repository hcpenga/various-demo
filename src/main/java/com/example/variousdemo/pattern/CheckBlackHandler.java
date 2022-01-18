package com.example.variousdemo.pattern;

import com.sun.mail.iap.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.misc.Request;

@Component
@Order(3)
public class CheckBlackHandler extends  AbstractHandler{

    @Override
    void doFilter(Request request, Response response) {
        System.out.println("责任链模式:已通过黑名单检测");
    }
}
