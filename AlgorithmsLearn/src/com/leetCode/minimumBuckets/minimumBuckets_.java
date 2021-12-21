// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-21 21:47
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个下标从 0 开始的字符串 street 。street 中每个字符要么是表示房屋的 'H' ，要么是表示空位的 '.' 。
 * <p>
 * 你可以在 空位 放置水桶，从相邻的房屋收集雨水。位置在 i - 1 或者 i + 1 的水桶可以收集位置为 i 处房屋的雨水。一个水桶如果相邻两个位置都有房屋，那么它可以收集 两个 房屋的雨水。
 * <p>
 * 在确保 每个 房屋旁边都 至少 有一个水桶的前提下，请你返回需要的 最少 水桶数。如果无解请返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.minimumBuckets;

public class minimumBuckets_ {
    public int minimumBuckets(String street) {
        // 1 考虑一个位置的时候
        //          一个位置的时候要么是-1要么是0
        // 2  多个位置的时候
        //          寻找房子，如果存在H.H的情况，说明只需要一个水桶就可以解决问题
        //          H..H..->需要两个桶
        //          以H开头，判断三个字符
        //          时间复杂度为O(n)
        //          HH..H  无法解决问题
        //          .HH.两个桶可以解决问题
        //          HH或结尾开头则无法解决问题
        //          .H H.H   .H.H  打断了H.H导致多算了一个

        int count = 0;
        if (street.length() == 1) {
            if (street.equals("H")) {
                return -1;
            } else {
                return 0;
            }
        }
        if ((street.charAt(0) == 'H' && street.charAt(1) == 'H') ||
                (street.charAt(street.length() - 1) == 'H' && street.charAt(street.length() - 2) == 'H')) {
            return -1;
        }
        for (int i = 0; i < street.length(); i++) {
            if (street.charAt(i) == 'H') {
                if (i + 2 > street.length() - 1) {
                    // H. OR .H
                    return count + 1;
                }

                if (street.charAt(i + 1) == '.') {
                    count += 1;
                    i += 2;
                } else {
                    // . HH
                    if (street.charAt(i - 1) == 'H' || street.charAt(i + 2) == 'H') {
                        // H HH、H HH.
                        return -1;
                    }
                    if (street.charAt(i + 2) == '.') {
                        // .HH..   OR  .HH.H
                            count += 2;
                            i += 3;
                    }
                }
            }
        }
        return count;
    }
}
