package com;// -*- coding: utf-8 -*-

import com.Sort.Utils.SortUtils;
import org.junit.jupiter.api.Test;

import java.util.*;


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
    public void transData() {
        String data = "[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]";
        System.out.println(
                data.replace('[', '{').replace(']', '}'));
    }

    @Test
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Test
    public void shout() {
        TreeMap<Integer, Integer> map = new TreeMap<>(Integer::compareTo);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        int[] task = {4, 5, 6};
        for (Integer next : map.keySet()) {
            System.out.println(map.get(next));
        }
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(6 - 2);
        System.out.println("--------------------------");
        System.out.println(entry == null ? "空" : entry.getValue());


    }


}


