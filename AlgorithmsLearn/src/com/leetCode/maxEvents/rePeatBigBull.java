// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-24 00:39
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxEvents;

import java.util.Arrays;
import java.util.PriorityQueue;

public class rePeatBigBull {
    // 优先队列 + 贪心算法
    public int maxEvents(int[][] events) {
        int ans = 0;
        PriorityQueue<Integer> SDM = new PriorityQueue<>();
        // 按照开始日期升序排序
        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });
        int start = events[0][0];
        int index = 0;
        while (index < events.length || !SDM.isEmpty()) {
            // 栈不为空或者小于会议信息没遍历完表示还有会议没有安排
            while (index < events.length && events[index][0] == start) {
                // 往优先队列中添加同一天开始的会议
                SDM.add(events[index][1]);
                ++index;
            }
            // 删除优先队列中已经无法参加的会议
            while (!SDM.isEmpty() && SDM.peek() < start) {
                SDM.poll();
            }
            // 一天只能参加一次会议
            if (!SDM.isEmpty()) {
                SDM.poll();
                ++ans;
            }
            ++start;
        }
        return ans;
    }
}
