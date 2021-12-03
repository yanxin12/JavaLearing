// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 12:05
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.test;

import java.util.UUID;

public class test {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            String s = uuid.toString();
        }

    }
}
