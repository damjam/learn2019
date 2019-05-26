package com.firstep.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author libaozhu
 * @date 2019/4/14 19:28
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap();
        map.put("b", 12);
        map.put("a", 11);
       for(Map.Entry entry: map.entrySet()){
           System.out.println(entry.getKey()+"="+entry.getValue());
       }
       Map<String, Object> map2 = new HashMap<>();
       map2.put("a", 1);
        System.out.println(map);
    }
}
