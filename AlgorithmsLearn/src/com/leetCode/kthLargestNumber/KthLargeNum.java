// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-06 20:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.kthLargestNumber;

public class KthLargeNum {
    public static void main(String[] args) {
        kthLargestNumber kthLargestNumber = new kthLargestNumber();
        String[] nums = {
                "623986800", "3", "887298", "695", "794", "6888794705", "269409", "59930972",
                "723091307", "726368", "8028385786", "378585"};
        String kthStringNum = kthLargestNumber.getKthStringNum(nums, 11);
        System.out.println(kthStringNum);

    }
}
