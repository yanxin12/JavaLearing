// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-29 22:41
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.findMinHeightTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BigBullSolution {
    // 使用BFS方法
    // 需要存储每层节点的个数，queue.size() 实现
    // 1 将点数据进行初始化，计算每个点的出度和相邻点（适用Map数据结构存储）
    // 2 每次将树的叶子节点进队列，然后计算每层节点个数，适用for循环BFS当前节点
    // 3 广度优先遍历可以让图越宽越矮
    // 4 深度优先遍历可以让图越短越高
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        // 1 计算每个节点的出度
        // 用于存储每个节点的初度
        int[] degree = new int[n];
        // 记录每个节点的相邻节点数据
        List<List<Integer>> map = new ArrayList<>();
        // 建立的map变量需要进行初始化
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            // 边界点存储信息为[a-b]
            degree[edge[0]]++;
            degree[edge[1]]++;
            // 记录点的连接信息
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        // 将当前出度为一的节点入队进行BSF遍历
        Queue<Integer> layer = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                layer.offer(i);
            }
        }
        while (!layer.isEmpty()) {
            // 当前层叶子节点的个数
            int size = layer.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int poll = layer.poll();
                res.add(poll);
                List<Integer> neighbors = map.get(poll);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        layer.offer(neighbor);
                    }
                }
            }
        }

        return res;
    }
}
