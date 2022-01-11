package com.example.variousdemo.helper;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestHelper {

    private Map<String,String> testMap = null;

    @PostConstruct
    public void init(){
        testMap = new HashMap<>();
        testMap.put("one","test-one");
        testMap.put("two","test-two");
        testMap.put("three","test-three");
    }

    public Map getTestMap(){
        return testMap;
    }
}
