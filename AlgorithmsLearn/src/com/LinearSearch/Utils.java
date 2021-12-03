// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-11-29 00:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.LinearSearch;

import com.Sort.Utils.SortUtils;

public class Utils extends SortUtils {
    ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException =
            new ArrayIndexOutOfBoundsException();

    // 线性查找数组最小值
    public int minSearch(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
        }
        return min;
    }

    // 线性查找最大值
    public int maxSearch(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    // 线性查找最大最小值
    public int[] minMaxSearch(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (A.length % 2 == 1) {
            min = A[0];
            max = A[0];
            // A的长度为奇数
            for (int i = 1; i < A.length; i += 2) {
                if (A[i] > A[i + 1]) {
                    if (A[i] > max) {
                        max = A[i];
                    }
                    if (A[i + 1] < min) {
                        min = A[i + 1];
                    }
                } else if (A[i] < A[i + 1]) {
                    if (A[i] < min) {
                        min = A[i];
                    }
                    if (A[i + 1] > max) {
                        max = A[i + 1];
                    }

                }
            }
        } else {
            // A的长度为偶数
            for (int i = 0; i < A.length; i += 2) {
                if (A[i] > A[i + 1]) {
                    if (A[i] > max) {
                        max = A[i];
                    }
                    if (A[i + 1] < min) {
                        min = A[i + 1];
                    }
                } else if (A[i] < A[i + 1]) {
                    if (A[i] < min) {
                        min = A[i];
                    }
                    if (A[i + 1] > max) {
                        max = A[i + 1];
                    }

                }
            }
        }
        return new int[]{min, max};


    }

    // 暴力查找数组的第k小数
    public int selectKthSmallest_SelectSort(int[] A, int k) {
        if (k - 1 > A.length) {
            System.out.println("数组越界！");
            return Integer.MIN_VALUE;
        }
        for (int i = 0; i <= k - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    swap(A, i, j);
                }
            }
        }

        return A[k - 1];

    }

    // 线性查找数组的第K小元素
    // 1 使用快速排序方法

    /**
     * @param A 待查找数组
     * @param p 查找起始位置
     * @param r 查找结束位置
     * @param i 查找的第i小的数据
     */
    public int selectKthSmallest_QuickSort(int[] A, int p, int r, int i) {
        if (p == r) {
            return A[p];
        }
        int pivot = randomPartition(A, p, r);
        int k = pivot - p + 1;
        if (k == i) {
            return A[pivot];
        } else if (k > i) {
            return selectKthSmallest_QuickSort(A, p, pivot - 1, i);
        } else {
            return selectKthSmallest_QuickSort(A, pivot + 1, r, i - k);
        }
    }

    // 2 使用线性查找算法BFPRT求解

    /**
     * @param A 寻找第i小元素数组
     * @param p 数组起始位置
     * @param r 数组结束位置
     * @param i 所需要寻找的第i小的数据
     *          分组->中位数->中位数的中位数
     */
    public int findMinimumByBFPRT(int[] A, int p, int r, int i) {
        if (i<1||i>A.length){
            System.out.println("i的范围超出数组界限！");
            throw arrayIndexOutOfBoundsException;
        }

        if (p == r) {
            return A[p];
        }

        int pivot = getMediansOfMedians(A, p, r);
        int[] a = partationOfBFPRT(A, p, r, pivot);
        // 比较所求第几个数和中位数的中位数进行比较
        if (i >= (a[0] + 1) && i <= (a[1] + 1)) {
            return A[i - 1];
        } else if (i < (a[0] + 1)) {
            // 因为返回的是坐标值，所以需要+1
            return findMinimumByBFPRT(A, p, a[0] - 1, i);
        } else {
            return findMinimumByBFPRT(A, a[1] + 1, r, i);
        }
    }

    // 获取中位数，长度为偶数时，默认返回小的中位数
    // 1 暴力获取
    public int median(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A[A.length - 1 >> 1];
    }

    // 2 快速排序思想
    // 找出中间大小的数字即可
    // 获取数组分组后中位数的中位数函数
    public int getMediansOfMedians(int[] A, int p, int r) {
        // 将数组A分成5组，分别求出每组的中位数
        // A的最后一组需要进行特殊处理
        // 将每组的中位数录入一个中位数数组中
        // 根据求数组黑箱子求出中位数的中位数，并且返回
        int offset = ((r - p + 1) % 5 == 0) ? 0 : 1;//判断A的最后一组是够有5个
        int range = (r - p + 1) / 5 + offset; // 如果A的最后一组不足5，仍然进行整合为一组
        int[] median = new int[range]; // 中位数数组
        // 将数组的中位数整合到中位数数组中
        for (int i = 0; i < range; i++) {
            int begin = p + i * 5;
            int end = Math.min(begin + 4, r);
            int sum = begin + end;
            int interval = (sum >> 1) + ((sum) % 2) + 1; // 如果长度为偶数，返回后面一个中位数
            // 因为序号从0开始，所以坐标需要+1
            median[i] = selectKthSmallest_QuickSort(A, begin, end, interval - begin);
        }
        int interval = median.length / 2 + ((median.length) % 2) + 1;
        // 因为序号从0开始，所以坐标需要+1
        int res = selectKthSmallest_QuickSort(median, 0, median.length - 1, interval);
        return res;

    }

    // BFPRT划分，根据找出的中位数的中位数对原数组进行划分
    // 并且返回主元相等的区间
    public int[] partationOfBFPRT(int[] A, int p, int r, int median) {
        int less = p - 1;
        int cur = p;
        int more = p - 1;
        while (cur <= r) {
            if (A[cur] < median) {
                ++less;
                ++more;
                swap(A, less, cur);
                if (more != less) {
                    swap(A, more, cur);
                }
            } else if (A[cur] == median) {
                ++more;
                swap(A, more, cur);
            }
            ++cur;
        }
        return new int[]{less + 1, more};// 返回主元区间坐标
    }

}
