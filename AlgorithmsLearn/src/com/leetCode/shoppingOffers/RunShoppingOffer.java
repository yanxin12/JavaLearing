// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-22 10:12
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.shoppingOffers;

import java.util.ArrayList;
import java.util.List;

public class RunShoppingOffer {
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<Integer>() {{
                        add(3);
                        add(0);
                        add(5);
                    }}
        );
        special.add(new ArrayList<Integer>() {{
                        add(1);
                        add(2);
                        add(10);
                    }}
        );
        List<Integer> needs = new ArrayList<Integer>() {{
            add(3);
            add(2);
        }};
        System.out.println(new BigBullResolution().shoppingOffers(price, special, needs));
        System.out.println(new RePeatBigBullResolution().shoppingOffers(price, special, needs));

    }
}
