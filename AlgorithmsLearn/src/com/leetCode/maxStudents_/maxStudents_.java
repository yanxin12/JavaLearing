// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-03 14:48
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
 * <p>
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
 * <p>
 * 学生必须坐在状况良好的座位上。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-students-taking-exam
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.maxStudents_;

public class maxStudents_ {
    public int maxStudents(char[][] seats) {
        // 类似于八皇后问题，考生左边、右边、左上、右上都坐不了人
        // 存在坏掉的椅子，考生只能坐在符号为'.'的代表椅子可以坐的地方
        // 需要时刻更改seats矩阵
        // 难点： 如何安排考生就坐可以到达教室可以容纳最多考生数目
        /*考生的视角使用两个视野数组实现对范围的界定*/
        int[] x = {-1, 1, -1, 1};
        int[] y = {0, 0, -1, -1};
        int n = seats.length; // 矩阵的行
        int m = seats[0].length; // 矩阵的列
        int res = 0; // 记录考场所能容纳的最大考生数量
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (seats[i][j] == '.') {
                    seats[i][j] = '*';
                    // 当前位置可以做，需要对改变视野范围内的可坐椅子情况
                    ++res;
                    for (int k = 0; k < 4; k++) {
                        if (j + x[k] >= 0 && j + x[k] < m && i + y[k] >= 0) {
                            if (seats[i + y[k]][j + x[k]] != '#')
                                seats[i + y[k]][j + x[k]] = '*';
                        }  // 将视野范围内的椅子状态调整为不可坐
                    }
                }
            }
        }
        return res;
    }
}
