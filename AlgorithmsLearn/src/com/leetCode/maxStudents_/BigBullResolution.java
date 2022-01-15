// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-03 17:51
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxStudents_;

import java.util.stream.IntStream;

public class BigBullResolution {
    // 使用动态规划算法（dynamic programming DP）
    public int maxStudents(char[][] seats) {
        final int n = seats.length, m = seats[0].length;

        // （空间还可以优化）
        int[][] dp = new int[n + 1][1 << m];
        for (int i = 1; i <= n; i++) {
            // 位1表示坏了
            int invalid = 0;
            for (int j = 0; j < m; j++) {
                if (seats[i - 1][j] == '#') {
                    // 1000 |= 0011 = 1011-> 8 |= 3 =11
                    invalid |= 1 << j;
                }
            }
            for (int j = 0; j < (1 << m); j++) {
                // 来判断相邻位置
                int adjacentMask = j << 1;
                // 坐在坏椅子上或相邻座位已坐，舍弃该状态
                if ((j & invalid) != 0 || (j & adjacentMask) != 0) {
                    dp[i][j] = -1;
                    continue;
                }

                int theOtherAdjacentMask = j >>> 1;
                // 如果状态可行，遍历上一行的所有状态，寻找状态最大值
                for (int s = 0; s < (1 << m); s++) {
                    // 如果 s 不合法，舍弃状态 s
                    if (dp[i - 1][s] == -1) {
                        continue;
                    }
                    // 如果相邻列已坐，舍弃状态 s
                    if ((s & adjacentMask) != 0 || (s & theOtherAdjacentMask) != 0) {
                        continue;
                    }
                    // 状态转移
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][s] + Integer.bitCount(j));
                }
            }
        }

        //noinspection OptionalGetWithoutIsPresent
        return IntStream.of(dp[n]).max().getAsInt();
    }
}
