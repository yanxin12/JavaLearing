// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-21 23:19
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.minimumBuckets;

public class BigBull {
    public int minimumBuckets(String street) {
        int count = 0;
        int lastBucket = -2;
        // 1 查找桶，如果桶左边已经有一个水桶则不作任何处理
        // 2 优先在桶的右边摆放，如果右边没有位置而左边没有桶，则在左边摆放
        for (int i = 0; i < street.length(); i++) {
            if (street.charAt(i) == 'H') {
                if (i - 1 == lastBucket) {
                    // 左边有水桶，则不作任何处理
                } else if (i + 1 < street.length() && street.charAt(i + 1) == '.') {
                    // 右边有位置可以摆放水桶
                    ++count;
                    lastBucket = i + 1;
                } else if (i - 1 >= 0 && street.charAt(i - 1) == '.') {
                    ++count;
                    lastBucket = i - 1;
                } else {
                    return -1;
                }


            }
        }
        return count;
    }
}
