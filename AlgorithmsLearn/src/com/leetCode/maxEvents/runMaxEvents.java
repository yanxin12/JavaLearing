// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-23 23:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxEvents;

public class runMaxEvents {
    public static void main(String[] args) {
        int[][] events = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        System.out.println(new maxEvents_().maxEvents(events));
        System.out.println(new rePeatBigBull().maxEvents(events));
    }
}
