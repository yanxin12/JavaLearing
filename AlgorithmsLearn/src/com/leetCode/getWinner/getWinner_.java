// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-26 21:11
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * <p>
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * <p>
 * 返回赢得比赛的整数。
 * <p>
 * 题目数据 保证 游戏存在赢家。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.getWinner;

public class getWinner_ {
    public int getWinner(int[] arr, int k) {
        // 线性遍历
        int max = arr[0];
        int p = k;
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                // 当前值赢了一次
                p = k;
                flag = false;
            }
            --p;
            if (p == 0) {
                if (flag) {
                    return arr[i - k];
                } else {
                    return arr[i - k + 1];
                }

            }
        }
        // 遍历一次还没有找到解则直接返回数组的最大值
        return max;
    }
}
