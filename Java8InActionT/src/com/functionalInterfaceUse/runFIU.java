// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-12 22:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.functionalInterfaceUse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class runFIU {
    public void shoutT(functionalInterfaceUse ffu) {
        ffu.shout();
    }

    @Test
    public void shout() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.forEach((a) -> System.out.println(a + "：hello!"));
        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + "：world");
            }
        });
     /*   shoutT(() -> {
            System.out.println("I am shouting!");
        });*/
        shoutT(new functionalInterfaceUse() {
            @Override
            public void shout() {
                System.out.println("I am shouting too!");
            }
        });
    }

}
