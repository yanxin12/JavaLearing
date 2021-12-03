// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-27 22:11
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Sort.countSort;

import com.Sort.Utils.SortUtils;

public class countSort {
    public static void main(String[] args) {
        SortUtils utils = new SortUtils();
//        int[] A = {22, 53, 31, 15, 30, 26, 36, 60, 38};
//        int[] A = {221, 532, 313, 154, 305, 266, 367, 78, 89};
//        int[] A = {0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 6, 6, 6, 6, 8, 8, 9, 24, 56, 97};
        int[] A = {0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        int[] res = utils.radixSort(A, 10, 2);
        for (int re : res) {
            System.out.print(re + "\t");
        }
    }
}
