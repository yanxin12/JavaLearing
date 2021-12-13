// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-13 10:34
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxPoints;

public class runMaxPoints {
    public static void main(String[] args) throws IllegalAccessException {
//        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        maxPoints_ maxPoints_ = new maxPoints_();
        System.out.println(new BigBullSolution().maxPoints(points));
    }
}



