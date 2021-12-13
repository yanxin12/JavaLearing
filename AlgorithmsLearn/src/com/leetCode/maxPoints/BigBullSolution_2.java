// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-13 12:21
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxPoints;

import java.util.HashMap;

public class BigBullSolution_2 {
    //2 优化之后的朴素枚举法
    public int maxPoints(int[][] points) {
        int ans = 1;
        int n = points.length;
        int a = 0, b = 0;
        // 使用Map存储斜率相同的点
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int[] x = points[i];
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j];
                a = y[0] - x[0];
                b = y[1] - x[1];
                int k = gcb(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max+1);
        }
        return ans;
    }

    // 求两个数的最大公分母
    public int gcb(int a, int b) {
        return b == 0 ? a : gcb(b, a % b);
    }
}
