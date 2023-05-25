package com.omcart.core.apractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestOutput {
    public static void main(String[] args) {
        Map<Integer, String> map=new HashMap<>();
        map.put(1,"om");
        map.put(2,"prakash");
        map.put(3,"dhiraj");

        Set<Integer> set=map.keySet();
        for (Integer key:set ) {
            String value= map.get(key);
            System.out.println(value);
        }

    }
}
