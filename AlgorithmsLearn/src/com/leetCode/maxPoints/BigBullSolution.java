// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-13 11:43
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxPoints;

public class BigBullSolution {
    // 1 朴素枚举法
    public int maxPoints(int[][] points) {
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] y = points[j];
                int cns = 2; // 大佬的牛逼之处往往在不经意间展现
                for (int k = j + 1; k < points.length; k++) {
                    int[] p = points[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) {
                        ++cns;
                    }
                }
                ans = Math.max(cns, ans);
            }
        }
        return ans;
    }
}
