// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 21:22
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.purchasePlans;

import java.util.Iterator;
import java.util.TreeSet;

public class purchasePlans_ {
    public int purchasePlans(int[] nums, int target) {
        // 使用TreeMap进行排序，使用tailEntry方法计算小于target
        int ans = 0;
        TreeSet<Integer> data = new TreeSet<>(Integer::compare);
        for (int i : nums) {
            if (i < target) {
                data.add(i);
            }
        }
        Iterator<Integer> iterator = data.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            ans += data.headSet(target - next, true).size();
        }
        return ans;
    }
}
