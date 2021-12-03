// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-11-28 09:54
 * IDE: IntelliJ IDEA
 * Introduction:
 * 假设给了你n个红色的水壶和n个蓝色的水壶。它们的形状和尺寸都各不相同。所有的红色水壶
 * 中所盛的水都不一样多（不存在重复数据），蓝色水壶也是如此。而且对每一个红色水壶来说都
 * 存在一个对应的蓝色水壶，两者盛有一样多的水；反之亦然
 */
package com.Sort.RedBlueKettle;


import com.Sort.Utils.SortUtils;

public class RedBlueKettleSort {
    public static void main(String[] args) {
        int[] Red = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] Blue = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortUtils utils = new SortUtils();
        utils.quickSortkettle(Red, Blue, 0, Red.length - 1);
        for (int i : Red) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i : Blue) {
            System.out.print(i + "\t");
        }


    }
}
