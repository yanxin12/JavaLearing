// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-06 00:25
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.MaxBytesLength;

import java.util.HashMap;

public class PreFixSum {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int pre_sum = 0;
            int ret = 0;
            for (int i = 0; i < nums.length; i++) {
                pre_sum += nums[i] == 0 ? -1 : 1;
                if (map.containsKey(pre_sum)) {
                    ret = Math.max(ret, i - map.get(pre_sum));
                } else {
                    map.put(pre_sum, i);
                }
            }
            return ret;
        }
}
