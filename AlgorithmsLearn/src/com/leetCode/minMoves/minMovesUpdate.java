// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 01:01
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.minMoves;

public class minMovesUpdate {
    // 判断数组中的数值是否全部相等
    public static boolean ifEnd(int[] nums) {
        // 实现判断数组中所有元素是否相等
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    // 创建获取数组中最大最小值方法
    public static int[] getMinMaxValues(int[] nums) {
        int min = nums[0];
        int minIndex = 0;
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return new int[]{min, max, minIndex, maxIndex};
    }

    public int minMoves_(int[] nums) {
        // 1 数组长度不定
        // 2 每次选出数组的最大值不改变值
        // 3 原方法每次遍历只对每个值加一，速度慢，改进想法是每个值在一个点加多几次
        // 4 需要辅助变量记录操作次数（最小）
        // 5 如果数组中存在相同的最大值，则选取左边的最大值
        // 6 每次对数组进行操作之后需要判断数组中的所有值是否大小相等
        // 7 需要选出数组的最小值，每次步进的长度为最大值和最小值之差
        // 8 每次操作之后需要判断数组中所有数值是否大小相等
        int opetaNums = 0;
        int step = 0;
        while (!ifEnd(nums)) {
            int[] minMaxValues = getMinMaxValues(nums);
            step = minMaxValues[1] - minMaxValues[0]; // 以数组中最大最小值的差值作为步进长度
            for (int i = 0; i < nums.length; i++) {
                if (i != minMaxValues[3]) {
                    // 出数组中选取的一个最大值之外，其他所以数据都加上步进长度
                    nums[i] += step;
                }
            }
            opetaNums += step;
        }
        return opetaNums;
    }
}
