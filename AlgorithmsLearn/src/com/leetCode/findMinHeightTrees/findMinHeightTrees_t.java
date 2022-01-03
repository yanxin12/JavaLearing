// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-29 00:39
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.findMinHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class findMinHeightTrees_t {
    // 初始化全局变量，用于存储各节点为根节点时候的树的深度信息
    HashMap<Integer, Integer> treeData = new HashMap<>();
    Stack<Integer> node = new Stack<>();

    // 使用DFS实现无向图的构建最小生成树的根节点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 1 深度优先遍历可以测量树的深度
        // 2 广度优先遍历实现比较复杂
        // 3 深度优先遍历需要采用递归操作，树的深度信息保留在每次递归栈中
        // 4 因为是从无向图构建最小生成树，所以使用边的矩阵表示方式，在对每一个节点通过广度优先遍历
        //  返回以当前节点为根节点的树的深度信息，
        // 5 每棵树的深度信息保留在一个集合里面，最后通过比较集合里面每个值的深度信息选出最小生成树的根节点
        // 边节点信息是无向的,把边信息转化为矩阵信息
        // 6 在遍历边矩阵的时候需要动态修改边的状态，因为DFS算法只适用于有向图
        int[][] edges_data = new int[n][n];
        ArrayList<Integer> res = new ArrayList<>();
        // 用于存储最小树的信息
        for (int[] edge : edges) {
            int row = edge[0];
            int col = edge[1];
            edges_data[row][col] = 1;
            edges_data[col][row] = 1;
            // 有向图的实现就是遍历到一条边，则另一条边设置为0
        }
        // int min = getMinH(0, edges_data);
//        System.out.println("--------------------");
//        System.out.println(getMinH(9, edges_data));
//        System.out.println("--------------------");
        int min = Integer.MAX_VALUE;
        //vres.add(0);
        for (int i = 0; i < n; i++) {
            int tmp = getMinH(i, edges_data);
            if (tmp == min) {
                res.add(i);
            } else if (tmp < min) {
                // 清除大的，独占结果
                res.clear();
                res.add(i);
                min = tmp;
            }
        }
        return res;
    }

    // 实现测量给定树的高度的方法
    public int getMinH(int root, int[][] edges_source) {
        // 拷贝边界点信息
        int n = edges_source.length;
        int[][] edges = new int[n][n];
        for (int i = 0; i < edges_source.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                edges[i][j] = edges_source[i][j];
            }
        }

        // 1 需要判断节点没有孩子节点的情况
        boolean hasChild = false;
        node.push(root);
        int len = 0;// 获取每个节点树的深度
        // 一个节点为根进行一次遍历
        // 1 - 0 和 0 - 1 会造成无限循环入栈和出栈操作
        while (!node.isEmpty()) {
            int p = node.pop();
            for (int i = 0; i < edges.length; i++) {
                if (edges[p][i] == 1) {
                    // 有边
                    hasChild = true;
                    edges[i][p] = 0;// DFS算法的实现需要一个有向图
                    // 需要保存每一个孩子节点的深度信息，返回最长的那个
                    len = Math.max(len, getMinH(i, edges) + 1);
                }
            }
            if (!hasChild) {
                return 1;
            }
        }
        return len;
    }
}
