package Sort.QuickSort;

import Sort.Utils.SortUtils;
// -*- coding: utf-8 -*-

/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-23 00:26
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class QuickSort {
    public static void main(String[] args) {
//        int[] A = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] A = {2, 8, 7, 10, 3, 5, 6, 4, 10, 10, 10};
        int[] A = {1, 6, 5, 6, 6, 5, 3, 4, 2, 3, 3, 2, 2, 2};
//        quickSort(A,0,A.length-1);
        SortUtils sortUtils = new SortUtils();
        int[] partition = sortUtils.partitionM(A, 0, A.length - 1);
//        sortUtils.quickSort(A, 0, A.length - 1);
        System.out.println("pivot position:" + partition[0] + "-" + partition[1]);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + "\t\t");
        }

    }

    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        // pivot element select
        int x = q[l + r >> 1];
        // Compare position come from the array two point
        int i = l - 1, j = r + 1;
        // When the programing finished the number i will bigger than
        // the number j
        while (i < j) {
            do {
                ++i;
            } while (q[i] < x);
            do {
                --j;
            } while (q[j] > x);
            // exchange the posion
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}
