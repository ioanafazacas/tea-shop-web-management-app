package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public enum Category {
    BLACK(0), GREEN(1), FLORAL(2), MEDICINAL(3);
    private int value;
    private static Map map = new HashMap();
    private Category(int value){
        this.value=value;
    }
    static {
        for (Category pageType : Category.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static Category valueOf(int pageType) {
        return (Category) map.get(pageType);
    }

    public int getValue() {
        return value;
    }

}
