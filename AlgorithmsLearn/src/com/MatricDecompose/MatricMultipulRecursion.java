package com.MatricDecompose;// -*- coding: utf-8 -*-

/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-24 01:05
 * IDE: IntelliJ IDEA
 * Introduction:
 * 使用迭代法计算矩阵乘法
 */

public class MatricMultipulRecursion {
    public static void main(String[] args) {
//        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {5, 6, 7, 8}};
//        int[][] B = {{1, 0, 0, 0}, {0, 6, 0, 0}, {0, 0, 3, 0}, {0, 0, 0, 8}};
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] res = multipulMatric(A, B);
        for (int i = 0; i < res.length; i++) {
            System.out.println();
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "\t");
            }
        }


    }

    /**
     * 使用迭代的方式实现矩阵相乘 要求矩阵维数为2的幂
     */
    public static int[][] multipulMatric(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[0][1];
        C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        return C;

    }
    //迭代调用二维矩阵乘法

    //边长二维矩阵每一维都可以初始化
    public int[][] YangHui(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
            }
        }
        return triangle;
    }
}


