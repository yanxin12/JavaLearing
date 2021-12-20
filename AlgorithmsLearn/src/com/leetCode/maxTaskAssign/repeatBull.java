// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-20 21:59
 * IDE: IntelliJ IDEA
 * Introduction:
 *  摘抄一份大佬的解题思路：
 *      一、摘要
 *
 * 本文介绍了一种使用 二分 和 贪心算法相结合的解法。参考了大佬吴自华的题解。
 * 代码中利用了C++ STL中multiset<int>的lower_bound()函数实现二分，复杂度为O(n*logn*logn)。
 * 二、题解及代码
 *
 * 一个显然的结论是，假如可以完成m个工作，那么一定也可以完成(m-1)个工作；假如m个工作不能完成，那么m+1个工作也一定不能完成。
 * 因此可以使用二分算法假设可能完成的工作数目范围为[left, right]。判断mid=(left+right)/2个工作能否完成，
 * 如果能完成mid个工作，那么在[mid+1,right]范围能查找，不然就在[left,mid-1]范围内查找，不断缩小查找范围。
 *
 * 在判断能否完成mid个任务时，使用贪心算法。
 * 显然我们最好选择最有力气的mid个工人，和最容易完成(力量需要最小)的mid个任务。
 * 假如工人workers[i],workers[j],...,workers[z]完成工作tasks[x]需要相同个数的药丸pill,那么我们为了最大化每个工人的价值(有点资本家压榨工人的意思喽。。。)自然要选择workers[i],...,workers[z]中力量最小的那个工人。
 * 因此我们依旧可以使用二分，对于选出的mid个任务，从最难的任务开始选择工人：
 *
 *     假如存在可以不嗑药就完成该工作的工人，选择其中最弱的工人；
 *     假如不存在不嗑药就能完成该工作的工人，就选择嗑药最少的工人中力量最小的工人；
 *     在选择工人时，假如一个工人需要嗑药的数目大于1，或者已经没有药可以磕了，就说明不能完成这mid个任务。
 *
 * 代码实现中需要注意的几点：
 *
 *     需要判断药丸功效(strength)为0的情况；
 *     需要使用multiset<>记录力量最大的mid个工人，不能使用set<>因为可能有几个工人力量一样大；
 *     每个工人最多只能嗑一个药丸；
 *
 * 作者：sthemmm
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-tasks-you-can-assign/solution/5913-er-fen-tan-xin-by-sthemmm-41cs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 */
package com.leetCode.maxTaskAssign;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class repeatBull {
    // 自己的分配方法行不通，只好采用大佬的方法
    // 大佬的方法从用二分方法和贪心算法的结合
    // 用较大的工人去匹配较小的任务量
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int start = 0;
        int end = Math.min(tasks.length, workers.length) - 1;
        int find = -1;
        int mid = 0;
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

    public boolean ok(int[] tasks, int[] workers, int pills, int strength, int k) {
        // 判断工人数组的最大的k个人能否被完全分配
        TreeMap<Integer, Integer> workerStrength = new TreeMap<>(Integer::compare);
        for (int i = workers.length - k; i < workers.length; i++) {
            int c = workerStrength.getOrDefault(workers[i], 0) + 1;
            workerStrength.put(workers[i], c);
        }
        int count = 0;
        for (int i = k - 1; i >= 0; i--) {
            // 获取最大力量的工人信息
            Map.Entry<Integer, Integer> maxWork = workerStrength.lastEntry();
            if (maxWork.getKey() >= tasks[i]) {
                count++;
                workerStrength.compute(maxWork.getKey(), (key, v) -> v == 1 ? null : v - 1);
            } else {
                if (pills > 0) {
                    Map.Entry<Integer, Integer> integerIntegerEntry = workerStrength.ceilingEntry(tasks[i] - strength);
                    if (integerIntegerEntry != null) {
                        ++count;
                        --pills;
                        workerStrength.compute(integerIntegerEntry.getKey(), (key, v) -> v == 1 ? null : v - 1);
                    }
                }
            }

        }
        return count == k;
    }
}
