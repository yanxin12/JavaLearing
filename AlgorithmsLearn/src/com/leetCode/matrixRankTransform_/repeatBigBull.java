// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-30 19:39
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.matrixRankTransform_;

import java.util.Arrays;

public class repeatBigBull {
    // I want to repeat the answer of big bull
    // I can't use and i have forgot the principle of Union-find set
    // 使用并查集解决问题
    /**
     * cores:
     * 1 并查集的使用
     * 2 多维矩阵转化为一维矩阵->一维索引转化为矩阵下标
     * 3 索引的排序按照矩阵中元素的大小进行排序（多维数据转化为一维数据的妙处）->对矩阵中的元素按照升序进行排序
     * 排序的目的是为了遍历矩阵数据的时候可以从矩阵中的元素按照从小到大的次序进行遍历，这样每次遍历的时候当前值的大小或者当前
     * 秩的大小都会是当前行或者当前列的最大元素
     * 4 需要记录每一行和每一列中元素的最大值和最小值的元素位置，因为矩阵中的元素会出现相同的情况，如果相同的时候需要秩需要+1
     */
    int[] p; // 并查集数组
    int[] vals;  // 用于存放矩阵秩的数组
    int[] rowMaxRank;
    int[] colMaxRank;
    Integer[] indexs; // 比较器需要传入包装类？


    // 1 并查集
    // 确认是否是同一个帮派
    public int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // 帮派之间的合并
    public void union(int a, int b) {
        // 如果a 、 b不同帮派，则b将加入a的帮派
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            p[pb] = pa;
        }
    }

    // 将多维数据转化为一维数据进行处理
    public int[][] matrixRankTransform(int[][] matrix) {
        /*获取矩阵的行列信息*/
        int row = matrix.length;
        int col = matrix[0].length;
        /* 初始化辅助数组的信息 */
        p = new int[row * col];
        vals = new int[row * col];
        indexs = new Integer[row * col];
        colMaxRank = new int[col];
        rowMaxRank = new int[row];
        Arrays.fill(colMaxRank, -1);
        Arrays.fill(rowMaxRank, -1);
        // 初始化并查集信息
        for (int i = 0; i < row * col; i++) {
            p[i] = i;
            indexs[i] = i;
        }
        // 对序号数组进行排序，使得遍历序号数组的时候是按照矩阵中元素从小到大的循序进行遍历
        Arrays.sort(indexs, (Integer i, Integer j) -> matrix[i / col][i % col] - matrix[j / col][j % col]);
        int pos = 0;
        while (pos < row * col) {
            /*填写秩矩阵*/
            Integer cur = indexs[pos];
            int i = cur / col;
            int j = cur % col;
            int val = 1; // 每一个元素刚开始的秩设置为一
            if (rowMaxRank[j] != -1) {
                // 如果当前元素所在行存在以前遍历过的最大元素，则需要进行判断
                // 因为存在相等的情况，如果相等则加入并查集
                int k = rowMaxRank[j];
                int tempId = i * col + k;
                int tempLeader = find(tempId);
                int tempVal = vals[tempLeader];
                if (matrix[i][j] == matrix[i][k]) {
                    union(cur, tempId);
                    val = tempVal;
                } else {
                    val = tempVal + 1;
                }
            }
            if (colMaxRank[i] != -1) {
                int k = colMaxRank[i];
                int tempId = k * col + j;
                int tempLeader = find(tempId);
                int tempVal = vals[tempLeader];
                if (matrix[i][j] == matrix[k][j]) {
                    union(cur, tempVal);
                    val = Math.max(val, tempVal);
                } else {
                    val = Math.max(val, tempVal + 1);
                }

            }
            rowMaxRank[i] = j;
            colMaxRank[j] = i;
//            int leader = cur;
//            vals[leader] = find(leader);
            int leader = find(cur);
            vals[leader] = val;
            ++pos;


        }
        int[][] res = new int[row][col];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                // res[i][j] = vals[i * col + j];
                int idx = i * col + j;
                res[i][j] = vals[find(idx)];
            }
        }
        return res;

    }


}
