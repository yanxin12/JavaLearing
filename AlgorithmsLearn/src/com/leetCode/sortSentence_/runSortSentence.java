// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-02 14:10
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.sortSentence_;

public class runSortSentence {
    public static void main(String[] args) {
//        String s = "is2 sentence4 This1 a3";
        String s = "QcGZ4 TFJStgu3 HvsRImLBfHd8 PaGqsPNo9 mZwxlrYzanuVOUZoyNjt1 fzhdtYIen6 mV7 LKuaOtefsixxo5 pwdEK2";

        String res1 = new sortSentence_().sortSentence(s);
        String res2 = new sortSentenceUpdate().sortSentence(s);
        System.out.println(res1);
        System.out.println(res2);
        res1 = res1.trim();
        if (res2.charAt(0) == ' ') {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }


    }
}
