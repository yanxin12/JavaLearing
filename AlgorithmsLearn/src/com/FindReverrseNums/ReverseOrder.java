package com.FindReverrseNums;// -*- coding: utf-8 -*-

/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-22 19:54
 * IDE: IntelliJ IDEA
 * Introduction:
 */

//确定n个元素的任何排列中逆序对数量的算法
class ReverseOrder {
    public static int reverseNums = 0;

    public static void main(String[] args) {
        int[] A = {9,8,7,6,5,4,3,2,1};
        findReverseOrder_sort(A, 0, A.length - 1);
        System.out.println(reverseNums);
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + "\t\t");
        }

    }

    public static void findReverseOrder(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int i = 0, j = 0, k = p;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (; i < n1; ++i) {
            L[i] = A[p + i];
        }
        for (; j < n2; ++j) {
            //A[q]值在左边
            R[j] = A[q + j + 1];
        }
        i = 0;
        j = 0;
        while (i < n1 && j < n2) {
            if (L[i] > R[j]) {
                //存在一个逆序对
                //  将右边小的值直接放入数组导致少算
                for (int temp = i; temp < n1; temp++) {
                    if (L[temp] > R[j]) {
                        reverseNums++;
                    }
                }
                A[k++] = R[j++];
            } else {
                A[k++] = L[i++];
            }
        }
        while (i < n1) {
            A[k++] = L[i++];
//            System.out.println(L[i]);
        }
        while (j < n2) {
            A[k++] = R[j++];
        }


    }

    public static void findReverseOrder_sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (r + p) / 2;
            findReverseOrder_sort(A, p, q);
            findReverseOrder_sort(A, q + 1, r);
            findReverseOrder(A, p, q, r);
        }
    }


}
