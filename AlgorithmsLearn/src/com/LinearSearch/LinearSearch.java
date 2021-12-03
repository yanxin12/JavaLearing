// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-11-29 00:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] A = {13, 56, 8, 98, 18, 66, 88, 100};
//        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        Utils utils = new Utils();

//        System.out.println(utils.selectKthSmallest_SelectSort(A, 6));
//        System.out.println("A.length is " + A.length);
//        System.out.println(utils.selectKthSmallest_QuickSort(A, 0, A.length - 1, (A.length  >> 1)));
//        System.out.println(utils.median(A));
        for (int i = 1; i <= A.length; i++) {
            System.out.println(
                    utils.findMinimumByBFPRT(A, 0, A.length - 1, i)
            );
        }
    }

}
