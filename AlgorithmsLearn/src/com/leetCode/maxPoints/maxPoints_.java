// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-13 01:12
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 暴力求解：
 * 1 最少有两个点在同一条直线上
 * 2 最多全部点在同一条直线上
 * 3 对所有可能构成不同直线的两个点构造直线
 * 4 通过遍历的方式计算每一条直线上点的个数
 * 5 利用两点式方程构造一条直线
 * (y-y1)/(y2-y1) = (x-1)/(x2-x1)->y=(x-1)*(y2-y1)/(x2-x1)  + y1
 */
package com.leetCode.maxPoints;

public class maxPoints_ {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int maxPoint = 0;
        int tmpMax = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    if (constructLineByTwoPoints(points[i], points[j], points[k])) {
                        ++tmpMax;
                    }
                }
                if (tmpMax > maxPoint) {
                    maxPoint = tmpMax;
                }
                tmpMax = 0;
            }
        }
        return maxPoint;
    }

    /**
     * 两点式直线方法,判断第三个点是否在两个点构成的直线上
     * 需要考虑斜率为0和斜率不为0的情况
     *
     * @param a 两点式一点
     * @param b 两点式一点
     * @param c 判断点
     * @return
     * @throws IllegalAccessException
     */
    public boolean constructLineByTwoPoints(int[] a, int[] b, int[] c) {
        // y=(x-x1)*(y2-y1)/(x2-x1)  + y1
        if (a[0] != b[0] && a[1] != b[1]) {
            // 应该避免使用除法，因为会除法强制l类型转换
            //  return c[1] == ((c[0] - a[0]) * (b[1] - a[1]) / (b[0] - a[0]) + a[1]);
            return (c[1] - a[1]) * (b[0] - a[0]) == (c[0] - a[0]) * (b[1] - a[1]);
        } else if (a[1] == b[1]) {
            // y2-y1 = 0 的时候，斜率为0，直线是一条横线
            return c[1] == a[1];
        } else {
            // x2-x1 = 0的时候，斜率为无穷，直线是一条竖线
            return c[0] == a[0];
        }
    }
}
