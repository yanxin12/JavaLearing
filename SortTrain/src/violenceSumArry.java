// -*- coding: utf-8 -*- 

/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-23 19:05
 * IDE: IntelliJ IDEA
 * Introduction:
 * 使用暴力算法求解最大子数组
 * 从左往右计算数组和，保存最大子数组和
 */

public class violenceSumArry {
    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//        int[] A = {-13, -3, -25, -20, -3, -16, -7};
        int[] ints = violenceArry(A);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] violenceArry(int[] A) {
        int max_sum = Integer.MIN_VALUE;
        int temp = 0, tab_p = 0, tab_r = 0;

        for (int j = 0; j < A.length; j++) {
            temp = 0;
            for (int i = j; i < A.length; i++) {
                temp += A[i];
                if (max_sum < temp) {
                    max_sum = temp;
                    tab_p = j + 1;
                    tab_r = i + 1;
                }

            }
        }
        return new int[]{tab_p, tab_r, max_sum};

    }


}
