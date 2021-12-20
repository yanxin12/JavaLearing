// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-21 00:06
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.fourSumCount;

public class fourSumCount_ {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 暴力解法，一一计算
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if (fourNum(nums1[i], nums2[j], nums3[k], nums4[l])) {
                            ++count;
                        }
                    }
                }
            }
        }
        return count;
    }

    public boolean fourNum(int i, int j, int k, int l) {
        // 方法实现判断四个数字之和是否为0
        return i + j + k + l == 0;
    }

}
