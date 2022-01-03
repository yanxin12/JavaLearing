// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-03 15:51
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxStudents_;

public class maxStudentUpdate {
    // 程序运行之后发现，当横着派座位的时候达不到教室可以容纳的最多学生人数
    // 决定尝试使用竖着对学生座位安排
    public int maxStudents(char[][] seats) {
        // 类似于八皇后问题，考生左边、右边、左上、右上都坐不了人
        // 存在坏掉的椅子，考生只能坐在符号为'.'的代表椅子可以坐的地方
        // 需要时刻更改seats矩阵
        // 难点： 如何安排考生就坐可以到达教室可以容纳最多考生数目
        /*考生的视角使用两个视野数组实现对范围的界定*/
        // 发现按列对考生作为安排的时候，会忽略掉左和右下角考生位置，所以这边的探查区域需要探查左和右下角
        int[] x = {-1, 1, -1, 1, -1, 1};
        int[] y = {0, 0, -1, -1, 1, 1};
        int n = seats.length; // 矩阵的行
        int m = seats[0].length; // 矩阵的列
        int res = 0; // 记录考场所能容纳的最大考生数量

        for (int j = m - 1; j >= 0; --j) {
            for (int i = n - 1; i >= 0; --i) {
                if (seats[i][j] == '.') {
                    seats[i][j] = '*';
                    // 当前位置可以做，需要对改变视野范围内的可坐椅子情况
                    ++res;
                    for (int k = 0; k < 6; k++) {
                        if (j + x[k] >= 0 && j + x[k] < m && i + y[k] >= 0 && i + y[k] < n) {
                            if (seats[i + y[k]][j + x[k]] != '#')
                                seats[i + y[k]][j + x[k]] = '$';
                        }  // 将视野范围内的椅子状态调整为不可坐
                    }
                }
            }
        }
        return res;
    }

}
