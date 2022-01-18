package com.example.variousdemo.pattern;

import com.sun.mail.iap.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.misc.Request;

/**
 * 安全检查检验
 */
@Component
@Order(2)
public class CheckSecurityHandler extends AbstractHandler{
    @Override
    void doFilter(Request request, Response response) {
        System.out.println("责任链模式:已经通过安全检查");
    }
}
