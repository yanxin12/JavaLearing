package com;// -*- coding: utf-8 -*-

import com.Sort.Utils.SortUtils;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-22 15:29
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class test {
    SortUtils utils = new SortUtils();

    public static void main(String[] args) {

//        ArrayList<Integer> heap = new ArrayList<>();
        List<Integer> heap = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            heap.add(i);
        }

        for (Integer integer : heap) {
            System.out.print(integer + "\t\t");
        }


    }


    @Test
    public static void test(List<Integer> heap) {
        System.out.println(heap.get(2));

    }


    @Test
    // 增强for循环无法初始化数组
    public void initial() {
        int[] B = {1, 2, 3};
        for (int i : B) {
            System.out.println(i);
            i = 0;
        }
        System.out.println("After initial!");
        for (int i : B) {
            System.out.println(i);
        }
    }

    @Test
    public void shout() {
        BigInteger a = BigInteger.valueOf(12345);
        BigInteger b = BigInteger.valueOf(12346);
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
    }

}
