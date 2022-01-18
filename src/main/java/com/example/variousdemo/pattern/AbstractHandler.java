package com.example.variousdemo.pattern;

import com.sun.mail.iap.Response;
import sun.misc.Request;

public abstract class AbstractHandler {
    //责任链的下一个对象
    private AbstractHandler nextHandler;

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void filter(Request request,Response response){
        doFilter(request,response);
        if(getNextHandler() != null){
            getNextHandler().filter(request,response);
        }
    }

    abstract void doFilter(Request request, Response response);
}
