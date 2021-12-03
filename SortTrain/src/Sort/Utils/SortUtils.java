// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-26 11:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Sort.Utils;

import org.junit.jupiter.api.Test;

public class SortUtils {
    public int partition(int[] A, int p, int r) {
        int temp;
        int i = p - 1;
        int x = A[r];//pivot
        for (int j = p; j < r; j++) {
            if (A[j] < x) {
                ++i;
                temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        temp = A[i + 1];
        A[i + 1] = x;
        A[r] = temp;
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
                temp = A[j];
                A[j] = A[i];
                A[i] = temp;
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
        int temp = 0;
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
        for (int i = 0; i < k; i++) {
            C[i] = 0;
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
        }
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int i = A.length; i > 0; --i) {
            B[C[A[i]]] = A[i];
            C[A[i]]--;
        }
        return B;
    }

    /**
     * @param A 待排序数据
     * @param r 数据取值上界
     */

    public void radixSort(int[] A, int r) {
        int[] ints = new int[r];


    }


}


