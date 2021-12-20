// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-21 00:15
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.fourSumCount;

import java.util.concurrent.ConcurrentHashMap;

public class fourSumCount_V2 {
    // 由于暴力破解方法超时，所以需要寻找一个巧妙的方法减少时间复杂度
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 整体遍历的时间复杂度为O(n^4),但是分开来计算的时间复杂度就不是O(n^4)了
        // 方法采用两两计算，再比较
        int count = 0;
        // 创建用于存储两个数组元素两两之和的集合，每个时间复杂度为n*n
//        HashMap<Integer, Integer> AB = new HashMap<>();
//        HashMap<Integer, Integer> CD = new HashMap<>();
        ConcurrentHashMap<Integer, Integer> AB = new ConcurrentHashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int c = AB.getOrDefault(nums1[i] + nums2[j], 0) + 1;
                AB.put(nums1[i] + nums2[j], c);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int c = nums3[i] + nums4[j];
                if (AB.containsKey(-c)) {
                    count += AB.get(-c);
                }
            }
        }

        return count;
    }
}
