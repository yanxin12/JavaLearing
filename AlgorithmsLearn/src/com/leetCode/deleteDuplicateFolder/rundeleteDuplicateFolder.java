// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-24 01:20
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.deleteDuplicateFolder;

import java.util.ArrayList;
import java.util.List;

public class rundeleteDuplicateFolder {
    public static void main(String[] args) {
        // [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
        List<List<String>> path = new ArrayList<>();
        List<String> subPath01 = new ArrayList<>();
        List<String> subPath02 = new ArrayList<>();
        List<String> subPath03 = new ArrayList<>();
        List<String> subPath04 = new ArrayList<>();
        List<String> subPath05 = new ArrayList<>();
        List<String> subPath06 = new ArrayList<>();
        subPath01.add("a");
        subPath02.add("c");
        subPath03.add("d");
        subPath04.add("a");
        subPath04.add("b");
        subPath05.add("c");
        subPath05.add("b");
        subPath06.add("d");
        subPath06.add("a");
        path.add(subPath01);
        path.add(subPath02);
        path.add(subPath03);
        path.add(subPath04);
        path.add(subPath05);
        path.add(subPath06);
        System.out.println(new BigBullSolution().deleteDuplicateFolder(path));

    }

}
