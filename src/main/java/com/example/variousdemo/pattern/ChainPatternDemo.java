package com.example.variousdemo.pattern;

import com.sun.mail.iap.Response;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.Request;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ChainPatternDemo {
    @Autowired
    private List<AbstractHandler> abstractHandlerList;

    private AbstractHandler abstractHandler;

    @PostConstruct
    public void initChain(){
        for(int i = 0 ; i < abstractHandlerList.size() ; i++){
            if(i == 0){
                abstractHandler = abstractHandlerList.get(0);
            } else {
                AbstractHandler currentHandler = abstractHandlerList.get(i - 1);
                AbstractHandler nextHandler = abstractHandlerList.get(i);
                currentHandler.setNextHandler(nextHandler);
            }
        }
    }

    public Response exec(Request request,Response response){
        abstractHandler.filter(request,response);
        return response;
    }

    public AbstractHandler getAbstractHandler() {
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler) {
        this.abstractHandler = abstractHandler;
    }
}

