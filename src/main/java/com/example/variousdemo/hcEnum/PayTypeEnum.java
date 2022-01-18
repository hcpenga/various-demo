package com.example.variousdemo.hcEnum;

import java.util.HashMap;
import java.util.Map;

public enum PayTypeEnum {

    UNKOWN("未知", 1),
    ALIPAY("支付宝", 1);

    private final String name;
    private final int code;
    private static final Map<Integer, PayTypeEnum> MAP;


    static {
        MAP = new HashMap<>();
        for (PayTypeEnum payTypeEnum : PayTypeEnum.values()) {
            MAP.put(payTypeEnum.getCode(), payTypeEnum);
        }
    }

    PayTypeEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static PayTypeEnum getByCode(int code) {
        PayTypeEnum payTypeEnum = MAP.get(code);
        return payTypeEnum != null ? payTypeEnum : UNKOWN;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
