// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-26 20:54
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.sMode;

public class sMode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 5, 6, 7, 8, 8, 8, 8, 8, 9};
        System.out.println(getMode(nums));
    }

    public static int getMode(int[] nums) {
        int step = 1;
        int mode = nums[0];
        int Modetime = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                ++step;
            } else {
                if (step > Modetime) {
                    Modetime = step;
                    mode = pre;
                }
                pre = nums[i];
                step = 1;
            }
        }
        return mode;
    }

}
