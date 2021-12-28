// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 22:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.purchasePlans;

import java.util.Arrays;

public class BigBullSolution_3 {
    //  计数法
    public int purchasePlans(int[] nums, int target) {
        long ans = 0;
        long mod = 1000000007;
        Arrays.sort(nums);
        long[] count = new long[100001];
        int[] repeat = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < 100001; i++) {
            count[i] += count[i - 1];
        }
        for (int num : nums) {
            if (num * 2 > target) break;
            ans = (ans + count[target - num] - count[num - 1] - repeat[num] - 1) % mod;
            // 当前值为num，不包括小于num的值，而且还需要减去重复值
            repeat[num]++;
        }
        return (int) ans;
    }
}


