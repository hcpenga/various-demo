package com.example.variousdemo.pattern;

import com.sun.mail.iap.Response;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.misc.Request;

/**
 * 参数校验
 */
@Component
@Order(1)
public class CheckHandler extends AbstractHandler{
    @Override
    void doFilter(Request request, Response response) {
        System.out.println("责任链模式:已经通过参数校验");
    }
}
