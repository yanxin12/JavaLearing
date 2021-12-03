// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-26 11:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Sort.Utils;

public class SortUtils {
    public int partition(int[] A, int p, int r) {
        int i = p - 1;
        int x = A[r];//pivot
        for (int j = p; j < r; j++) {
            if (A[j] < x) {
                ++i;
                swap(A, i, j);
            }
        }
        // r位置是pivot
        swap(A, i + 1, r);
        return i + 1;
    }

    public int partitionT(int[] A, int p, int r) {
        // 从两侧往中间比较
        int i = p;
        int j = r;
        int pivot = (p + r) >> 1;
        int x = A[pivot];
        int temp = 0;
        while (i < j) {
            while (A[i] < x) {
                ++i;
            }
            while (A[j] > x) {
                --j;
            }
            if (i < j) {
                swap(A, i, j);
            }
        }
        return i;

    }

    public void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int pivot = partitionT(A, p, r);
            quickSort(A, p, pivot);
            quickSort(A, pivot + 1, r);
        }
    }

    // 实现数组中出现重复数字的Partition方法
    public int[] partitionM(int[] A, int p, int r) {
        // 增加判断
        int x = A[r];
        int q = p - 1;
        int t = p - 1;
        for (int i = p; i < r; i++) {
            if (A[i] < x) {
                ++q;
                ++t;
                swap(A, q, i);
                if (q != t) {
                    swap(A, t, i);
                }
            } else if (A[i] == x) {
                ++t;
                swap(A, t, i);
            }
        }
        swap(A, t + 1, r);
        return new int[]{q + 1, t};
    }

    public void swap(int[] A, int a, int b) {
        int temp;
        temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    // 实现基数排序
    public int[] counterSort(int[] A, int k) {
        int[] C = new int[k];
        int[] B = new int[A.length + 1];
        // 初始化
        arrayInit(C);
        arrayInit(B);
        for (int j : A) {
            C[j]++;
        }
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int i = A.length - 1; i > 0; --i) {
            B[C[A[i]]] = A[i];
            C[A[i]]--;
        }
        return B;
    }

    // 实现多位数的基数排序

    /**
     * public int[] counterSortM(int[] A, int k) {
     * int[] C = new int[k];
     * int[] B = new int[A.length + 1];
     * // 初始化
     * arrayInit(C);
     * arrayInit(B);
     * // 此时A是多位数，应该提取最低位数的数字
     * for (int j : A) {
     * ++C[j % 10];
     * }
     * for (int i = 1; i < k; i++) {
     * C[i] = C[i] + C[i - 1];
     * }
     * // 对A的个位数数字按大小进行排序
     * for (int i = A.length - 1; i >= 0; --i) {
     * B[C[A[i] % 10]] = A[i];
     * C[A[i] % 10]--;
     * }
     * // 对A的十位数数字按大小进行排序
     * // 初始化
     * arrayInit(C);
     * // 指针改变
     * //        A = B;
     * for (int i = 1; i < B.length; i++) {
     * A[i - 1] = B[i];
     * }
     * arrayInit(B);
     * // 此时A是多位数，应该提取最低位数的数字
     * for (int i = 0; i < A.length; i++) {
     * ++C[(A[i] / 10) % 10];
     * }
     * for (int i = 1; i < k; i++) {
     * C[i] = C[i] + C[i - 1];
     * }
     * for (int i = A.length - 1; i >= 0; --i) {
     * B[C[(A[i] / 10) % 10]] = A[i];
     * C[(A[i] / 10) % 10]--;
     * }
     * return B;
     * }
     */
    // 实现多位数的基数排序（取出0下标影响）
    // 因为0下标的影响，导致最后C数组上数字定位超出数组界
    /*public int[] counterSortM(int[] A, int k) {
        int[] C = new int[k];
        int[] B = new int[A.length];
        // 初始化
        arrayInit(C);
        arrayInit(B);
        // 此时A是多位数，应该提取最低位数的数字
        for (int j : A) {
            ++C[j % 10];
        }
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        // 对A的个位数数字按大小进行排序
        for (int i = A.length - 1; i >= 0; --i) {
            B[C[A[i] % 10] - 1] = A[i];
            C[A[i] % 10]--;
        }
        // 对A的十位数数字按大小进行排序
        // 初始化
        arrayInit(C);
        // 指针改变
//        A = B;
        for (int i = 0; i < B.length; i++) {
            A[i] = B[i];
        }
        arrayInit(B);
        // 此时A是多位数，应该提取最低位数的数字
        for (int i = 0; i < A.length; i++) {
            ++C[(A[i] / 10) % 10];
        }
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int i = A.length - 1; i >= 0; --i) {
            B[C[(A[i] / 10) % 10] - 1] = A[i];
            C[(A[i] / 10) % 10]--;
        }
        return B;
    }*/
    // 简化代码
    public int[] radixSort(int[] A, int k, int digitNum) {
        int[] C = new int[k];
        int[] B = new int[A.length];
        int temp = 0;
        while (digitNum > 0) {
            // 初始化
            arrayInit(C);
            arrayInit(B);
            // 此时A是多位数，应该提取最低位数的数字
            for (int i = 0; i < A.length; i++) {
                ++C[(A[i] / (int) Math.pow(10, temp)) % 10];
            }
            for (int i = 1; i < k; i++) {
                C[i] = C[i] + C[i - 1];
            }
            for (int i = A.length - 1; i >= 0; --i) {
                B[C[A[i] / ((int) Math.pow(10, temp)) % 10] - 1] = A[i];
                C[A[i] / ((int) Math.pow(10, temp)) % 10]--;
            }
            arrayInit(A);
            for (int i = 0; i < B.length; i++) {
                A[i] = B[i];
            }
            ++temp;
            --digitNum;
        }
        return B;
    }

    // 数组初始化函数
    public void arrayInit(int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            Array[i] = 0;
        }
    }

    // 实现稳定的堆排序和快速排序
    // 增加一维数组对重复数据进行定位，排序完成之后按第二维度升序排列


    // 随机输入方法
    public int randomSelect(int p, int r) {
        return (int) (p + Math.random() * (r - p + 1));
    }

    // 红蓝水壶partition
    public int partitionkettle(int[] Red, int[] Blue, int p, int r) {
//        int rand = randomSelect(p, r);
        int rand = (p + r) >> 1;
        int bluepivot = 0;
        int redPivot = 0;
        // 使用随机找到的红色水壶作为pivot对蓝色水壶进行快速排序
        int x = Red[rand];//pivot
        int temp = 0;
        int i = p - 1;
        for (int j = p; j <= r; j++) {
            if (Blue[j] < x) {
                ++i;
                swap(Blue, i, j);
            }
        }
        // 找到蓝色水壶主元所在位置
        for (int k = 0; k < Blue.length; k++) {
            if (x == Blue[k]) {
                bluepivot = k;
                break;
            }
        }
        swap(Blue, i + 1, bluepivot);
        // 根据蓝色水壶的pivot(i+1)对红色水壶进行快速排序
        int pivotblue = i + 1;
        x = Blue[pivotblue];//pivot
        // 初始化
        temp = 0;
        i = p - 1;
        for (int j = p; j <= r; j++) {
            if (Red[j] < x) {
                ++i;
                swap(Red, i, j);
            }
        }
        // 找到红色主元所在位置
        for (int j = p; j < r; j++) {
            if (Red[j] == x) {
                redPivot = j;
                break;
            }
        }
        swap(Red, i + 1, redPivot);
        // 排序完成之后，红色和蓝色对应的主元应该在同一个位置
        return i + 1;
    }

    // 红蓝水壶快速排序
    public void quickSortkettle(int[] Red, int[] Blue, int p, int r) {
        if (p < r) {
            int pivot = partitionkettle(Red, Blue, p, r);
            quickSortkettle(Red, Blue, p, pivot);
            quickSortkettle(Red, Blue, pivot + 1, r);
        }
    }

    // 最坏情况为O(nlgn)的快速排序算法
    public void quickSort_E(int[] A, int p, int r) {
        /*为了使快速排序在最坏情况下也能保持比较排序的渐进上界
         * 使得快速排序的主元为中位数
         **/


    }

    // 随机选取主元的快速排序算法
    public int randomPartition(int[] A, int p, int r) {
        // 随机选取主元
        int randomNum = randomSelect(p, r);
//        System.out.println("The randomNum is " + randomNum);

        int x = A[randomNum];
//        int x = 8;
        int q = p - 1;
        int t = p - 1;
        for (int i = p; i <= r; i++) {
            if (A[i] < x) {
                ++q;
                ++t;
                swap(A, q, i);
                if (q != t) {
                    swap(A, t, i);
                }
            } else if (A[i] == x) {
                ++t;
                swap(A, t, i);
            }
        }
        return t;

    }

    public void quickSortRandomSelect(int[] A, int p, int r) {
        if (p < r) {
            int pivot = randomPartition(A, p, r);
            quickSortRandomSelect(A, p, pivot);
            quickSortRandomSelect(A, pivot + 1, r);
        }

    }


}
