// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-28 18:56
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.findMinHeightTrees;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class findMinHeightTrees_ {
    // 寻找最小高度树，每一个最小高度树最少有一个节点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 所有节点都可以作为根节点，但是并不是所有节点作为根节点的树都是最小树
        // 所以需要对每一个节点作为节点的树进行广度优先遍历（BFS），并且返回高度最小的树
        // 边节点信息是无向的,把边信息转化为矩阵信息
        int[][] edges_data = new int[n][n];
        // 用于存储最小树的信息
        TreeMap<Integer, Integer> TreeData = new TreeMap<>();

        for (int[] edge : edges) {
            int row = edge[0];
            int col = edge[1];
            edges_data[row][col] = 1;
            edges_data[col][row] = 1;
        }

        // 1 所有可能作为根节点的节点进入队列
        // Queue<Integer> root = new ArrayDeque<>();
        Queue<Integer> search = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 每一个节点都可以作为根节点
            search.offer(i);
            int treeLen = 0;

            while (!search.isEmpty()) {
                // 对每一个节点进行广度优先遍历
                Integer root = search.poll();
                for (int j = 0; j < n; j++) {
                    // 把树的所有孩子入队，方便以后遍历
                    if (edges_data[root][j] == 1) {
                        search.offer(j);
                    }
                }
                // 上面for循环实现每一层树节点的入队，所以这里的treeLen记录了当前树的高度
                ++treeLen;
                // 当队列为空的时候表明，以i为根节点的树已经遍历完成
            }
            TreeData.put(i, treeLen);
            // while (!root.isEmpty()){

        }

        return null;
    }
}
