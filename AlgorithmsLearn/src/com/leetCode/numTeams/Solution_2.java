// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-25 19:30
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.numTeams;

import java.util.HashSet;

public class Solution_2 {
    // 暴力匹配
    HashSet<int[]> ans = new HashSet<>();

    public int numTeams(int[] rating) {
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        ans.add(new int[]{rating[i], rating[j], rating[k]});
                    } else if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        ans.add(new int[]{rating[i], rating[j], rating[k]});
                    }
                }
            }
        }
        return ans.size();
    }
}
