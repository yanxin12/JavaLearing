package leetCode;// -*- coding: utf-8 -*-

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-22 23:40
 * IDE: IntelliJ IDEA
 * Introduction:
 */


public class MaxIceCream {
    public static void main(String[] args) {
        int[] costs = {7, 3, 3, 6, 6, 6, 10, 5, 9, 2};
        int coins = 56;
        System.out.println(maxIceCream(costs, coins));
        for (int i = 0; i < costs.length; i++) {
            System.out.print(costs[i] + "\t\t");
        }
    }

    @Test
    public static int maxIceCream(int[] costs, int coins) {
        int sum = 0;
        int i = 0;
        Arrays.sort(costs);
        while (i < costs.length) {
            if (sum < coins) {
                sum += costs[i++];
            } else if (sum == coins) {//钱花完了，还有雪糕没有买，直接不买了
                return i;
            } else {
                break;
            }
        }
        if (i == costs.length&&sum<coins) {
            //最后一个加上还有钱，当时i没有进去循环，无法增加,即最后一个不显示购买
            // 但是当卖最后一个价钱超过预期的时候则不该购买
            ++i;
        }
        return i - 1;
    }


}
