// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-17 00:35
 * IDE: IntelliJ IDEA
 * Introduction:
 * <p>
 * //
 * //        作者：wo-du-bu-zhi-dao
 * //        链接：https://leetcode-cn.com/problems/maximum-number-of-tasks-you-can-assign/solution/shi-yong-er-fen-fa-by-wo-du-bu-zhi-dao-5j9r/
 * //        来源：力扣（LeetCode）
 * //        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package com.leetCode.maxTaskAssign;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class BigBull {


    boolean ok(int[] tasks, int[] workers, int pills, int strength, int k) {
        // 获取最强的k的人
        TreeMap<Integer, Integer> pwoerK = new TreeMap<>(Integer::compare);
        for (int i = workers.length - k; i < workers.length; i++) {
            int c = pwoerK.getOrDefault(workers[i], 0) + 1;
            pwoerK.put(workers[i], c);
        }
        int count = 0;
        for (int i = k - 1; i >= 0; i--) {
            // 最大的任务 tasks[i];
            Map.Entry<Integer, Integer> maxWork = pwoerK.lastEntry();
            if (maxWork.getKey() >= tasks[i]) {
                count++;
                pwoerK.compute(maxWork.getKey(), (key, v) -> v == 1 ? null : v - 1);
            } else {
                if (pills > 0) {
                    Map.Entry<Integer, Integer> integerIntegerEntry = pwoerK.ceilingEntry(tasks[i] - strength);
                    if (integerIntegerEntry != null) {
                        count++;
                        pills--;
                        pwoerK.compute(integerIntegerEntry.getKey(), (key, v) -> v == 1 ? null : v - 1);
                    }
                }
            }
        }
        return count == k;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int find = -1;
        int mid = 0;
        int end = Math.min(tasks.length, workers.length) - 1;
        int start = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            boolean ok = ok(tasks, workers, pills, strength, mid + 1);
            if (ok) {
                start = mid + 1;
                find = mid;
            } else {
                end = mid - 1;
            }
        }
        return find + 1;
    }
}

