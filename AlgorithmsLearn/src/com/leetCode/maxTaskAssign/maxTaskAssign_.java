// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 20:25
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你 n 个任务和 m 个工人。每个任务需要一定的力量值才能完成，需要的力量值保存在下标从 0 开始的整数数组 tasks 中，第 i 个任务需要 tasks[i] 的力量才能完成。每个工人的力量值保存在下标从 0 开始的整数数组 workers 中，第 j 个工人的力量值为 workers[j] 。每个工人只能完成 一个 任务，且力量值需要 大于等于 该任务的力量要求值（即 workers[j] >= tasks[i] ）。
 * <p>
 * 除此以外，你还有 pills 个神奇药丸，可以给 一个工人的力量值 增加 strength 。你可以决定给哪些工人使用药丸，但每个工人 最多 只能使用 一片 药丸。
 * <p>
 * 给你下标从 0 开始的整数数组tasks 和 workers 以及两个整数 pills 和 strength ，请你返回 最多 有多少个任务可以被完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-tasks-you-can-assign
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.maxTaskAssign;

import java.util.Arrays;

/**
 * Question
 * 1 药片怎么分配
 * 2  如何安排
 * Thought
 * 1 有任务数组、工人数组，都是没有排序的，未知数量的神奇药片
 * 2 将任务数组和工人数组按相同的规律排好序
 * 3 比对排好序的两个数组，如果工人数组的数值大于任务数组的数值，则说明该工人可以分配到该任务上
 * 如果该工人的力量小于任务值大小，说明工人无法胜任该任务，需要找力量大的工人（不吃药片）帮忙，而且找的是
 * 无法胜任对应位置任务的工人
 * 4 将不吃药片就能工作的工人安排好之后，对药片进行分配，工人和任务需要按顺序进行分配
 */
public class maxTaskAssign_ {
    // 算法分配方式出现错误，没有将最接近的工人分配给对应任务
    // 例如：tasks = {2,2,4,4,5,6},works = {1,2,3},pills = 2,strength =1
    // 按照本算法计算只能分配两个工人，实际上可以分配三个工人
    // 改进思路：没嗑药完成不了不代表嗑药之后完成不了
    // 假如药的效力大于工人的力量，如果直接嗑药可能使得分配的工人力量浪费严重
    // 导致后面有些工人没药嗑，没法被分配，而且如果能找到不嗑药就可以完成这个任务的工人
    // 则可以省下一颗药
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // 1 按照相同的方式进行排序
        Arrays.sort(tasks);
        Arrays.sort(workers);
        // 2 分配不嗑药就可以干活的工人
        int len = Math.min(tasks.length, workers.length);
        int t = 0, w = 0;
        int assignedNum = 0;
        // 记录工人任务
        int[] assignedData = new int[workers.length];
        int[] taskData = new int[tasks.length];
        // 初始化
        Arrays.fill(assignedData, -1);
        while (t < tasks.length && w < workers.length) {
            // 任务分配完或者工人分配完就结束程序
            if (taskData[t] == 0 && workers[w] > tasks[t]) {
                // 直接分配
                assignedData[w] = t;
                taskData[t] = 1;
                ++assignedNum;
                ++w;
                ++t;
            } else {
                // 此时当前工人无法胜任工作
                // 寻找力量大的工人，并且该工人无法胜任其对应工作，或者其没有对应工作
                while (true) {
                    ++w;
                    if (w > workers.length - 1) {
                        // 工人排完了
                        break;
                    } else if (w < tasks.length && workers[w] >= tasks[w]) {
                        // 中间工人能够胜任对应工作
                        // 直接分配
                        assignedData[w] = w;
                        taskData[w] = 1;
                        ++assignedNum;
                    } else if (((w >= tasks.length - 1) && workers[w] >= tasks[t]) ||
                            (w < tasks.length && (workers[w] < tasks[w]) && (workers[w] >= tasks[t]))) {
                        // 直接分配
                        assignedData[w] = t;
                        taskData[t] = 1;
                        ++assignedNum;
                        ++t;
                        ++w;
                        break;
                    }
                }
            }
        }

        // 3 发挥神奇药片的作用
        t = 0;
        for (int i = 0; i < assignedData.length; i++) {
            if (assignedData[i] == -1) {
                while (taskData[t] == 1) {
                    // 定位未分配任务
                    if (t == taskData.length - 1) {
                        // 任务分配完毕
                        return taskData.length;
                    }
                    ++t;
                }
                // 当前工人未分配工作
                if (pills > 0 && (taskData[t] == 0) && (workers[i] + strength) >= tasks[t]) {
                    // 直接分配
                    assignedData[i] = t;
                    taskData[t] = 1;
                    ++assignedNum;
                    --pills;
                }
            }
        }
//        for (int i = 0; i < assignedData.length; i++) {
//            System.out.println(i + "号工人对应" + assignedData[i] + "号任务");
//        }
//        System.out.println(pills);

        return assignedNum;
    }
}
