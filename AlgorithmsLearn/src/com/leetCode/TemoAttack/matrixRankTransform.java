// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-30 08:38
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.TemoAttack;

public class matrixRankTransform {
    public int[][] matrixRankTransform(int[][] matrix) {
        //  求矩阵转换之后的秩
        // 需要记录每一行和每一列的最大值
        // 需要遍历两次矩阵
        int n = matrix.length;
        int m = matrix[0].length;
        // 用于存储矩阵中行的最大值和列的最小值
        int[] rowBig = new int[n];
        int[] colBig = new int[m];


        // 需要遍历两边，第一遍初始化矩阵的秩
        // 第二遍比较矩阵中的数值和当前行和列中的最大值，如果大于则需要比较秩的大小，如果秩小则设为秩+1
        int[][] rank = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                setRank(matrix[i][j], i, j, matrix, rank);
            }
        }

        return null;
    }

    // 给定输入元素，计算矩阵的秩
    public boolean setRank(int entry, int i, int j, int[][] matrix, int[][] rank) {
        for (int k = 0; k < matrix.length; k++) {
            // 遍历矩阵entry同一行元素
            if (matrix[i][k] > entry) {
                rank[i][j]++;
            }
        }
        for (int k = 0; k < matrix[0].length; k++) {
            // 遍历矩阵entry同一列元素
            if (matrix[k][j] > entry) {
                rank[i][j]++;
            }
        }
        return true;
    }

}
