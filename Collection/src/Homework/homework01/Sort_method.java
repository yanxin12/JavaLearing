// -*- coding: utf-8 -*- 
/**
 * Project: Collection
 * Creator: yanking
 * Create time: 2021-08-15 21:09
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

import java.util.List;

public class Sort_method {
    public void bubbleSort(List list) {
        // 使用冒泡排序实现给定列表的升序排序
        for (int i = list.size() - 1; i > 0; --i) {
            for (int j = 0; j < i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.price> book2.price){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }

            }

        }


    }
}
