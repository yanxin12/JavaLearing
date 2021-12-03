// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-27 00:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.Homework.homework03;

import java.util.*;

@SuppressWarnings({"all"})
public class homework03 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);
        map.put("jack",2600);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            next.setValue(next.getValue()+100);
            System.out.println(next.getKey()+next.getValue());
        }
        Collection values = map.values();
        for (Object value :values) {
            System.out.println(value);
        }




    }
}
