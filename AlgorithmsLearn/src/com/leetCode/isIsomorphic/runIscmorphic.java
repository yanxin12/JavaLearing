// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-28 01:24
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.isIsomorphic;

public class runIscmorphic {
    public static void main(String[] args) {
//        String s = "badc";
//        String t = "baba";
        String s = "egg";
        String t = "add";
//        String s = "paper";
//        String t = "title";
        System.out.println(new isIsomorphic_().isIsomorphic(s, t));
        System.out.println(new BigBullSolution().isIsomorphic(s, t));
    }
}
