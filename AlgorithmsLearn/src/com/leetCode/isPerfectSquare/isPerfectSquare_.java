// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 20:09
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.isPerfectSquare;

public class isPerfectSquare_ {

        public boolean isPerfectSquare(int num) {
            for(int i = 0;i<=(int)((num+1)/2);++i){
                if(num == i*i){
                    return true;
                }
            }
            return false;
        }

}
