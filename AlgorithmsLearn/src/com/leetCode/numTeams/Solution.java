// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-24 11:22
 * IDE: IntelliJ IDEA
 * Introduction:
 * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * <p>
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * <p>
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * <p>
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 */
package com.leetCode.numTeams;

public class Solution {
    int ans = 0;

    public int numTeams(int[] rating) {
        // 尝试递归实现
        for (int i = 0; i < rating.length; i++) {
            dfs(rating, rating[i], i, 0, true);
            dfs(rating, rating[i], i, 0, false);
        }
        return ans;
    }

    /**
     * @param rating  士兵分数
     * @param preRate 上一个士兵分数
     * @param start   下一个士兵开始位置
     * @param turn    分数的排序方式
     */
    public void dfs(int[] rating, int preRate, int start, int serialNum, boolean turn) {
        if (start >= rating.length) {
            return;
        }
        if ((turn && rating[start] >= preRate) ||
                (!turn && rating[start] <= preRate)) {
            ++serialNum;
            if (serialNum == 3) {
                ++ans;
                // 为了实现继续往后找
                dfs(rating, preRate, start + 1, serialNum - 1, turn);
            } else {
                dfs(rating, rating[start], start + 1, serialNum, turn);
            }
        } else {
            dfs(rating, preRate, start + 1, serialNum, turn);
        }
        // 回溯
        if (serialNum == 2) {
            dfs(rating, preRate, start + 1, serialNum - 1, turn);
        }
    }
}
