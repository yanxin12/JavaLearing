// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 00:46
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.minMoves;

public class Run {
    public static void main(String[] args) {
        int[] nums = {1, 1, 10000000};
        minMovesUpdate02 update02 = new minMovesUpdate02();
        int i = update02.minMoves(nums);
        System.out.println(i);
    }
}
