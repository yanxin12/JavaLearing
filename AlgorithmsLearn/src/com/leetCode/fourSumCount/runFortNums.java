// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-21 01:01
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.fourSumCount;

public class runFortNums {
    public static void main(String[] args) {
        int[] nums1 = {-1, -1};
        int[] nums2 = {-1, 1};
        int[] nums3 = {-1, 1};
        int[] nums4 = {1, -1};
        System.out.println(new fourSumCount_V2().fourSumCount(nums1, nums2, nums3, nums4));
        System.out.println("--------暴力方法--------");
        System.out.println(new fourSumCount_().fourSumCount(nums1, nums2, nums3, nums4));
    }
}
