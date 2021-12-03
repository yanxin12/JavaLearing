// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 19:29
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.YoungMatric;

public class YoungMatricUtils {
    // 判断数字是否存在YOUNG矩阵中
    public boolean isExist(int[][] A, int num) {
        int len = A.length;
        int i = len - 1;
        int j = 0;
        while (A[i][j] != num) {
            if (A[i][j] > num) {
                i--;
            } else {
                j++;
            }
            if (i >= A.length || j >= A[i].length) {
                return false;
            }
        }
        return true;
    }
}