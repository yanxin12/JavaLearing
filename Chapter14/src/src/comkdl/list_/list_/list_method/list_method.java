// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-22 17:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.list_.list_.list_method;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class list_method {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        System.out.println(list);
        list.add(1,"贾宝玉");
        list.add(1,"林黛玉");
        System.out.println(list);
    }
}
