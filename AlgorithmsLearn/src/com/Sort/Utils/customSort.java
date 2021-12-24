package com.Sort.Utils;

import java.util.Arrays;

public interface customSort {
    // 使用Java自带的Arrays.Sort方法实现自定义排序
    // 1 自定义二维数组排序
    public static void main(String[] args) {
        Integer[] oneD = {1, 5, 4, 6, 8, 9};
        Arrays.sort(oneD, ((o1, o2) -> {
            return o1 - o2;
        }));
//        int[] oneD = {1, 5, 4, 6, 8, 9};
//        Arrays.sort(oneD, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                return false;
//            }
//        });
//        Arrays.sort(oneD, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });


        for (int i : oneD) {
            System.out.println(i);
        }
        System.out.println();
//         Arrays.sort(new int[][]{oneD}, Collections.reverseOrder());


    }


}
