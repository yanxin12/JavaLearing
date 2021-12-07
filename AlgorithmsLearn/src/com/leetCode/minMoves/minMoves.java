// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 00:17
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。
 * 返回让数组所有元素相等的最小操作次数。
 */
package com.leetCode.minMoves;

public class minMoves {
    public static boolean ifEnd(int[] nums) {
        // 实现判断数组中所有元素是否相等
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public int minMoves_(int[] nums) {
        // 1 数组长度不定
        // 2 每次选出数组的最大值不改变值，其他值+1
        // 3 需要辅助变量记录操作次数（最小）
        // 4 如果数组中存在相同的最大值，则选取左边的最大值
        // 6 每次对数组进行+1操作之后需要判断数组中的所有值是否大小相等
        int opetaNums = 0;
        while (!ifEnd(nums)) {
            int max = nums[0];
            int maxIndex = 0;
            // 当数组中的元素不相等的时候持续进行操作
            //  maxIndex = getMaxIndex(nums); // 获取数组中的
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < max) {
                    ++nums[i];
                } else {
                    // 最大值交换
                    max = nums[i];
                    ++nums[maxIndex];
                    maxIndex = i;
                }
            }
            ++opetaNums;
        }
        return opetaNums;
    }

}
