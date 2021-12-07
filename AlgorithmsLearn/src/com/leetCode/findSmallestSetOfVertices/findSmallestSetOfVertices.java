// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-06 23:54
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 * <p>
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 * <p>
 * 你可以以任意顺序返回这些节点编号。
 */
package com.leetCode.findSmallestSetOfVertices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class findSmallestSetOfVertices {
    public List<Integer> findSmallestSet(int n, List<List<Integer>> edges) {
        // 1 所给的边的集合为有向无环图
        // 2  存在到达不了的节点（使用辅助数组进行标记）
        // 遍历所有的边，对节点进行标记
        boolean[] node = new boolean[n];// 辅助数组，实现对可达到节点的标记
        for (int i = 0; i < node.length; i++) {
            node[i] = true;
        }
        List<Integer> res = new ArrayList<>();
        Iterator<List<Integer>> iterator = edges.iterator();
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            node[next.get(1)] = false; // 对边指向节点进行标记
        }
        for (int i = 0; i < node.length; i++) {
            if (node[i]) {
                // 不可到达节点
                res.add(i);
            }
        }
        return res;
    }
}
