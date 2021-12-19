// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-19 15:36
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxTaskAssign;

import java.util.Arrays;

public class maxTaskAssign_v3 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // 1 按照相同的方式进行排序
        Arrays.sort(tasks);
        Arrays.sort(workers);
        // 2 分配不嗑药就可以干活的工人
        int t = 0, w = 0;
        int assignedNum = 0;
        // 记录工人任务
        int[] assignedData = new int[workers.length];
        int[] taskData = new int[tasks.length];
        // 初始化
        Arrays.fill(assignedData, -1);
        while (t < tasks.length && w < workers.length) {
//            System.out.println("Here!");
            // 任务分配完或者工人分配完就结束程序
            if (taskData[t] == 0 && assignedData[w] == -1 && workers[w] > tasks[t]) {
                // 直接分配
                assignedData[w] = t;
                taskData[t] = 1;
                ++assignedNum;
                ++w;
                ++t;
            } else {
                // 此时当前工人无法胜任工作
                // 寻找力量大的工人，并且该工人无法胜任其对应工作，或者其没有对应工作
                int tw = w;
                while (true) {
                    if (w > workers.length - 1) {
                        ++t;
                        // 工人排完了
                        break;
                    } else if (workers[w] >= tasks[t]) {
                        // 贪心比较
                        if (pills > 0 && (workers[tw] + strength) < workers[w] && (workers[tw] + strength) >= tasks[t]) {
                            // 发现药片效果一般，但是可以支持工人完成任务，而且吃完药片之后比不上找的现在的工人
                            // 直接让w吃药完成过工作
                            assignedData[tw] = t;
                            taskData[t] = 1;
                            ++t;
                            ++assignedNum;
                            --pills;
                            break;
                        } else if (pills == 0 || ((workers[tw] + strength) > workers[w]) || (workers[tw] < tasks[t])) {
                            // 此时药片的效果显著，直接分配
                            assignedData[w] = t;
                            taskData[t] = 1;
                            ++assignedNum;
                            ++t;
                            ++w;
                            break;
                        }
                    } else {
                        ++w;
                    }
                }
            }
        }

        // 3 发挥神奇药片的作用
        // 什么任务需要分配药片？-> tasks[t]>max(every element of workers[])
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
//        System.out.println("pills = " + pills);

        return assignedNum;
    }

}
