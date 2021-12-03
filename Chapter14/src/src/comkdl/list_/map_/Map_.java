// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-25 14:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.list_.map_;

import java.util.*;


@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"张三丰");
        map.put(2,"张无忌");
        map.put(3,"赵敏");
//        System.out.println(map);
        Set set = map.entrySet();
//        for (Object obj : set) {
//            Map.Entry entry =  (Map.Entry) obj;
//            System.out.println(entry.getKey()+"-" +entry.getValue());
//            System.out.println(entry.getClass());
//        }
        Set set1 = map.keySet();
        Collection set2 = map.values();
//        System.out.println(set1.getClass());
//        System.out.println(set2.getClass());
//        set2.removeAll();
//        System.out.println(set1);
//        System.out.println(set2);
//        System.out.println(map.get(set1));
//        for (Object key :set1) {
//            System.out.print(key +"-" +map.get(key)+"\t");
//        }
//        2.迭代器
//        Iterator iterator = set1.iterator();
//        while (iterator.hasNext()) {
//            Object key =  iterator.next();
//            System.out.print(key +"-" +map.get(key)+"\t");
//        }

//   第二组：把values值取出.

//无法使用普通for循环遍历
//        第三组：通过EntrySet来获取k-v
//        1.增强for

//        for (Object entry :set) {
//            Map.Entry kv = (Map.Entry) entry;
//            System.out.print(kv.getKey()+"-"+kv.getValue()+"\t");
//        }

//        2.迭代器
//        Iterator iterator02 = set.iterator();
//        while (iterator02.hasNext()) {
//            Object entry =  iterator02.next();
//            Map.Entry kv = (Map.Entry) entry;
//            System.out.print(kv.getKey()+"-"+kv.getValue()+"\t");
//        }

    }
}
