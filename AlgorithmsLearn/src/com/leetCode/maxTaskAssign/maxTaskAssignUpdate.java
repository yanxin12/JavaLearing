// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-19 01:16
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxTaskAssign;

import java.util.Arrays;

public class maxTaskAssignUpdate {
    // 学习大佬的解题方法之后，觉得自己的方法还有修改的空间
    // 当当前工人的力量小于的对应的工作的强度时，直接根据最接近的大于该任务的工人完成该任务
    // 工人可以选择嗑药，而且数组排序方式可能需要改为降序
    // 尝试使用工人的右半部分去匹配任务的左半部分
    // 分配任务是以所能分配的最多工人数目，所以需要考虑工人数小于任务数的时候
    // 此时不必从最大任务开始分配，如果这样会浪费神奇药片的个数
    // 应该从和工人数目相同位置的任务处往下匹配

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // 1 按照相同的方式进行排序
        Arrays.sort(tasks);
        Arrays.sort(workers);
        // 2 分配不嗑药就可以干活的工人
        int len = Math.min(tasks.length, workers.length);
        // 使用贪心算法思想，按照工人的力量从大到小去匹配任务
        int w = workers.length - 1;
        int t = 0;
        if (tasks.length >= workers.length) {
            t = w;
        } else {
            t = tasks.length - 1;
        }
        int assignedNum = 0;
        // 记录工人任务
        int[] assignedData = new int[workers.length];
        int[] taskData = new int[tasks.length];
        // 初始化
        Arrays.fill(assignedData, -1);
        while (t >= 0 && w >= 0) {
            // 任务分配完或者工人分配完就结束程序
            if (taskData[t] == 0 && assignedData[w] == -1 && workers[w] >= tasks[t]) {
                // 直接分配
                assignedData[w] = t;
                taskData[t] = 1;
                ++assignedNum;
                --w;
            } else {
                // 此时当前工人无法胜任工作,根据服用药片之后的工作量匹配最接近的劳动力
                int index = 0;
                while (true) {
                    // 因为已经拍好序，所以从头开始找肯定是刚好大于
                    if (assignedData[index] == -1 && (workers[index] + strength) >= tasks[t] && pills > 0) {
                        // 相当于实现map中的ceilingEntry
                        // 直接分配
                        assignedData[index] = t;
                        taskData[t] = 1;
                        ++assignedNum;
                        --pills;
                        if (index == w) {
                            --w;
                        }
                        break;
                    } else {
                        ++index;
                    }
                    if (index >= workers.length) {
                        // 没找到适合的工人
                        break;
                    }
                }
            }
            // 无论任务有没有被分配，都需要对下一个任务进行匹配
            --t;
        }
        for (int i = 0; i < assignedData.length; i++) {
            System.out.println(i + "号工人对应" + assignedData[i] + "号任务");
        }
        System.out.println(pills);
        return assignedNum;
    }
}
