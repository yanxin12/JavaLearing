// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-15 15:32
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.referenceFunc;

import java.util.function.Function;

public class Letter {
    public static String addHeader(String text) {
        return "Jack:" + text;
    }

    public static String checkText(String text) {
        return text.replaceAll("labda", "Lambda");
    }

    public static String addTailer(String text) {
        return text + "Kind regards";
    }

    public static String connect(String text, Function<String, String> f) {
        return f.apply(text);
    }

}




