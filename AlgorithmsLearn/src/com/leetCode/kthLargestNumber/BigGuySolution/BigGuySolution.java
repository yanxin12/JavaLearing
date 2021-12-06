// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-06 20:35
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.kthLargestNumber.BigGuySolution;

import java.util.Arrays;

public class BigGuySolution {
    // 通过使用字典序（ASCALl码）和字符串长度的比较实现
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (
                o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        return nums[nums.length - k];
    }
}
