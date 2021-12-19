// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-19 14:39
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxTaskAssign;

import java.util.Arrays;

public class maxTaskAssign_v2 {
    // 过度依赖药片
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
            // 任务分配完或者工人分配完就结束程序
            if (taskData[t] == 0 && assignedData[w] == -1 && (workers[w] + strength) >= tasks[t] && pills > 0) {
                if (workers[w] >= tasks[t]) {
                    // 直接分配
                    assignedData[w] = t;
                    taskData[t] = 1;
                    ++assignedNum;
                    ++w;
                    ++t;
                } else {

                    // 直接分配
                    assignedData[w] = t;
                    taskData[t] = 1;
                    ++assignedNum;
                    ++w;
                    ++t;
                    --pills;

                }
            } else {
                // 此时当前工人无法胜任工作，就连嗑药也无法完成
                // 寻找力量大的工人，并且该工人无法胜任其对应工作，或者其没有对应工作
                int tw = w;
                ++w;
                while (true) {
                    ++tw;
                    if (tw > workers.length - 1) {
                        // 工人排完了
                        break;
                    } else if (tw < tasks.length && workers[tw] >= tasks[tw]) {
                        // 中间工人能够胜任对应工作
                        // 直接分配
                        assignedData[tw] = tw;
                        taskData[tw] = 1;
                        ++assignedNum;
                    } else if (((tw >= tasks.length - 1) && workers[tw] >= tasks[t]) ||
                            (tw < tasks.length && ((workers[tw] + strength) < tasks[tw]) && (workers[tw] >= tasks[t]))) {
                        // 直接分配
                        assignedData[tw] = t;
                        taskData[t] = 1;
                        ++assignedNum;
                        ++t;
                        break;
                    }
                }

            }
        }
        return assignedNum;
    }
}
