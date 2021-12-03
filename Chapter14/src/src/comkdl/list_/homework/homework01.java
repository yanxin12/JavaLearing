// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-22 17:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.list_.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class homework01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hsp");
        list.add("hsp");
        list.add("hsp");
        list.add("hsp");
        list.add(2,"韩顺平教育");
        System.out.println(list);
        System.out.println(list.get(2));
        list.set(3,"学习Java!");
        System.out.println(list);;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println("obj = "+ obj);
            
        }
        


    }
}
