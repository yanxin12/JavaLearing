// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-06 19:45
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 * <p>
 * 返回 nums 中表示第 k 大整数的字符串。
 * <p>
 * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 */
package com.leetCode.kthLargestNumber;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;

public class kthLargestNumber {
    public static void quickSortBigIntege(BigInteger[] q, int l, int r) {
        if (l >= r) return;
        // pivot element select
        BigInteger x = q[l + r >> 1];
        // Compare position come from the array two point
        int i = l - 1, j = r + 1;
        // When the programing finished the number i will bigger than
        // the number j
        while (i < j) {
            do {
                ++i;
            } while (q[i].compareTo(x) < 0);
            do {
                --j;
            } while (q[j].compareTo(x) > 0);
            // exchange the posion
            if (i < j) {
                BigInteger temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSortBigIntege(q, l, j);
        quickSortBigIntege(q, j + 1, r);
    }

    public String getKthStringNum(String[] nums, int k) {
        Arrays.sort(nums, ((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length()));
        Iterator<String> iterator = Arrays.stream(nums).iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        return new String(String.valueOf(nums[nums.length - k]));
    }

}
