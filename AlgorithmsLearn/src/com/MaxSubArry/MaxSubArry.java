package com.MaxSubArry;// -*- coding: utf-8 -*-

/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-23 13:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class MaxSubArry {
    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7, 32, 1, 55, -99};
//        int[] A = {13, -3, -25, 20, -3, -16, 7, 9};
//        int[] A = {-13, -3, -25, -20, -3, -16, -7};
//        int[] maxSubArry = findMaxSubArry(A, 0, A.length - 1);
//        for (int i : maxSubArry) {
//            System.out.println(i);
//        }
        int[] ints = lineMaxSubArry(A);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static int[] findMaxCrossingSubArry(int[] A, int p, int mid, int q) {
        //找出经过数组中间值的最大子数组
        //从中点往两边加
        int sum = 0, maxLeft = 0, maxRight = 0;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        //获取左边最大子数组
        for (int i = mid; i >= p; --i) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i + 1;
            }
        }
        //或得右边最大子数组
        sum = 0;
        for (int i = mid + 1; i <= q; ++i) {
            sum += A[i];
            if (rightSum < sum) {
                rightSum = sum;
                maxRight = i + 1;
            }
        }
        //合并两边最大子数组
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }

    public static int[] findMaxSubArry(int[] A, int p, int q) {
        int[] res = new int[3];
        if (p == q) {
            // 数组只有一个值，q = A.length-1
            return new int[]{p, p, A[p]};
        }
        int mid = (p + q) / 2;
        int[] letfsum = findMaxSubArry(A, p, mid);
        int[] rightsum = findMaxSubArry(A, mid + 1, q);
        int[] midsum = findMaxCrossingSubArry(A, p, mid, q);
        if (letfsum[2] > (Math.max(rightsum[2], midsum[2]))) {
            return letfsum;
        } else {
            return (rightsum[2] > midsum[2] ? rightsum : midsum);
        }
    }

    //最大线性子数组O(n)
    public static int[] lineMaxSubArry(int[] A) {
        int maxArryBegin = 0;
        int maxArryEnd = 0;
        int boundry = A[0];
        int maxSumArry = A[0];
        int tmpbegin = 0;
        for (int i = 1; i < A.length; i++) {
            if (boundry + A[i] > A[i]) {
                boundry += A[i];
            } else {
                boundry = A[i];
                tmpbegin = i;
            }
            //更新索引和最大子数组
            if (boundry > maxSumArry) {
                maxSumArry = boundry;
                maxArryBegin = tmpbegin;
                maxArryEnd = i;
            }
        }
        return new int[]{maxArryBegin, maxArryEnd, maxSumArry};
    }
}


