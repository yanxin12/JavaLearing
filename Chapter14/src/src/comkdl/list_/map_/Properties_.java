// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-25 23:11
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.list_.map_;

import java.util.LinkedHashMap;
import java.util.Properties;
@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(1,"1号");
//        System.out.println(properties);
//        System.out.println(properties.get(1));
//        System.out.println(properties.remove(1));
//        System.out.println(properties.getProperty("1"));
//        LinkedHashMap linkedHashMap = new LinkedHashMap();
//        linkedHashMap.put(1,"老韩1号");
//        linkedHashMap.put(2,"老韩2号");
//
//        linkedHashMap.put(4,"老韩4号");
//        linkedHashMap.put(3,"老韩3号");
//        System.out.println(linkedHashMap);
        properties.put(3,"3号");
        properties.put(2,"2号");

        properties.put(4,"4号");
        System.out.println(properties);

    }
}
