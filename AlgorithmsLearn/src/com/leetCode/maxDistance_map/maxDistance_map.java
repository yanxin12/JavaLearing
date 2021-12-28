// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-28 10:29
 * IDE: IntelliJ IDEA
 * Introduction:
 * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 * <p>
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果网格上只有陆地或者海洋，请返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.maxDistance_map;

import java.util.ArrayDeque;
import java.util.Queue;

public class maxDistance_map {
    public int maxDistance(int[][] grid) {
        // 初始化步长数组
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[] site = null;
//        int[] site;  两种数组初始化方式不一样

        boolean hasOcean = false;
        Queue<int[]> startPoint = new ArrayDeque<>();
        // 确定地图边界
        int m = grid.length, n = grid[0].length;
//        Queue<int[]> startPoint = new ArrayDeque<>();  这Queue并不是java.utils包下的队列类
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 将陆地坐标放入出发点地图
                if (grid[i][j] == 1) {
                    startPoint.offer(new int[]{i, j});
                }
            }
        }
        // 从队列各个出发点出发寻找海洋
        while (!startPoint.isEmpty()) {
            site = startPoint.poll();
            // 出发点位置
            int x = site[0];
            int y = site[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY >= n || newY < 0 || grid[newX][newY] != 0) {
                    // 当前位置超出地图范围或者当前位置被访问过，或者当前位置是陆地
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;// 曼哈顿距离是四个反向行走，每走一步一个距离
                // 因为一个海洋的位置只能被探索一次，所以每一个海洋的位置都是距离该海洋位置的最近陆地的距离
                // 所以，当返回startPoint位置访问的最后一个海洋位置的时候，该海洋位置则是此地图中海洋距离最近陆地距离，但是距离是最远的那片海洋
                startPoint.offer(new int[]{newX, newY});
                hasOcean = true;
            }

        }
        if (site == null || !hasOcean) {
            // 只有陆地或者只有海洋
            return -1;
        }
        return grid[site[0]][site[1]] - 1;
    }

    // 看完大佬题解对BFS的理解
    // 矩阵的广度优先搜索是多点，因为矩阵时无向图


//    public int getDistance(int[][] grid, int i, int j, int range_x, int range_y, int k) {
//        // 探索当前海洋到最近陆地的距离
//        // 确定地图边界值
//        // 以正方形形式进行探索，先共线，再斜角；D（共线）>D（共线斜角间隙）>D（斜角）
//        // 当进入下一层次的时候，正方形的直线和对角之间会存在一些未探查的方块，需要在进入下一层的时候进行探查
//
//        // 1 共线
//        int maxD = 0;
//        if (grid[i + 1][j] == 1 || grid[i - 1][j] == 1 || grid[i][j - 1] == 1 || grid[i][j + 1] == 1) {
//            // 共线
//            maxD = 1 + k;
//        } else if () {
//            // 需要探索共线和斜角之间的方块
//
//        } else if (grid[i + 1][j + 1] == 1 || grid[i - 1][j - 1] == 1 || grid[i + 1][j - 1] == 1 || grid[i - 1][j + 1] == 1) {
//            // 斜角
//            maxD = 2;
//        }
//
//    }

}
