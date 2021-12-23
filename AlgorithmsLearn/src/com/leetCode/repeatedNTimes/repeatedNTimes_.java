// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-23 01:46
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.repeatedNTimes;

import java.util.HashSet;
import java.util.Set;

public class repeatedNTimes_ {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int i = 0;i < nums.length;++i){
            // 遍历判断是否出现重复数字
            if(!res.contains(nums[i])){
                res.add(nums[i]);
            }else{
                return nums[i];
            }
        }
        return -1;
    }
}
