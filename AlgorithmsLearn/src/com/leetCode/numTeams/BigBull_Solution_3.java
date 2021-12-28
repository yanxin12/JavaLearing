// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-25 20:05
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.numTeams;

import java.util.TreeSet;

public class BigBull_Solution_3 {
    public int numTeams(int[] rating) {
        int ans = 0;
        TreeSet<Integer> all = new TreeSet<>();
        TreeSet<Integer> left = new TreeSet<>();
        for (int r : rating) {
            all.add(r);
        }
        for (int r : rating) {
            int allLess = all.headSet(r).size(), allGreater = all.tailSet(r + 1).size();
            int leftLess = left.headSet(r).size(), leftGreater = left.tailSet(r + 1).size();
            ans += leftLess * (allGreater - leftGreater);
            ans += leftGreater * (allLess - leftLess);
            left.add(r);
        }
        return ans;
    }
}
