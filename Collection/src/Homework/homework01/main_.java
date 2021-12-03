// -*- coding: utf-8 -*- 
/**
 * Project: Collection
 * Creator: yanking
 * Create time: 2021-08-15 20:41
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class main_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("三国演义",33.4,"罗贯中"));
        list.add(new Book("水  浒  传",50,"施耐庵"));
        list.add(new Book("西  游  记",38.4,"吴承恩"));
        list.add(new Book("红  楼  梦 ",46.4," 曹雪芹"));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        new Sort_method().bubbleSort(list);
        System.out.println("===============排序完成！==============");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }


    }
}
