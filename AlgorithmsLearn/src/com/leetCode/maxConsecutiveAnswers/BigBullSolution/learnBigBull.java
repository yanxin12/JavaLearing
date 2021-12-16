// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 11:20
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxConsecutiveAnswers.BigBullSolution;

public class learnBigBull {
    // 学习大佬思路，运用滑动窗口解法
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // 窗口左右指针
        int left = 0, right = 0;
        // 结果变量
        int ans = 0;
        // 连续字符数量变量
        int numT = 0, numF = 0;
        while (right < answerKey.length()) {
            // 当窗口的右边框没有触及由右边界的时候窗口可以继续右移
            // 移动的时候计算窗口内T\F分布
            if (answerKey.charAt(right) == 'T') {
                ++numT;
            } else {
                ++numF;
            }
            while (numF > k && numT > k) {
                // 窗口左移动
                if (answerKey.charAt(left) == 'T') {
                    --numT;
                } else {
                    --numF;
                }
                ++left;
            }
            // 因为窗口中的字符可以转化为全部相同的字符，所以此时窗口的大小为一个解
            ans = Math.max(ans, right - left + 1);

            ++right;
        }

        return ans;

    }
}
