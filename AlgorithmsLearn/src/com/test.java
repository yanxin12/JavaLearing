package com;// -*- coding: utf-8 -*-

import com.Sort.Utils.SortUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-22 15:29
 * IDE: IntelliJ IDEA
 * Introduction:
 */


public class test {
    SortUtils utils = new SortUtils();
    UnaryOperator<Integer> dda = x -> x + 1;

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String name = myScanner.next();
        if (checkPredicate(name, s -> s.length() > 5, b -> name.equals("Yang"))) {
            System.out.println("Yes!");
        }

//        ArrayList<Integer> heap = new ArrayList<>();
        //List<Integer> heap = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 0; i < 10; i++) {
//            heap.add(i);
//        }
//
//        for (Integer integer : heap) {
//            System.out.print(integer + "\t\t");
//        }


    }

    @Test
    public static void test(List<Integer> heap) {
        System.out.println(heap.get(2));

    }

    @Test
    public static boolean checkPredict(String name, Predicate<String> predicate) {
        return predicate.test(name);
    }

    public static boolean checkPredicate(String name, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(name);

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
    public void transData() {
        String data = "[[\"#\",\".\",\"#\",\"#\",\".\",\"#\"],[\".\",\"#\",\"#\",\"#\",\"#\",\".\"],[\"#\",\".\",\"#\",\"#\",\".\",\"#\"]]\n";
        System.out.println(
                data.replace('[', '{').replace(']', '}').replace('\"', '\''));
    }

    @Test
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Test
    public void shout() {
/*        System.out.println(bitCount_(011));
        System.out.println(bitCount_(39));
        System.out.println(bitCount2(011));
        System.out.println(bitCount2(3));*/
        //System.out.println(bitCount2(0b00000000000000001111111111111111));
        System.out.println(bitCount2(0x3f));
        System.out.println(repeatBitCount(0x3f));
    }

    @Test
    public int bitCount_(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                // 01023131 & 00000001
                ++count;
            }
            num >>= 1;
        }
        return count;
    }

    @Test
    public int bitCount2(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    @Test
    public int repeatBitCount(int i) {
        i = (i & 0x55555555) + ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i & 0x0f0f0f0f) + ((i >>> 4) & 0x0f0f0f0f);
        i = (i & 0x00ff00ff) + ((i >>> 8) & 0x00ff00ff);
        i = (i & 0x0000ffff) + ((i >>> 16) & 0x0000ffff);
        return i & 0x3f;
    }

    @Test
    public void say() {

    }


}


