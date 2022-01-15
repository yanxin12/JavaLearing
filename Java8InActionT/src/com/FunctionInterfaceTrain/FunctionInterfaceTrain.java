// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-12 23:35
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.FunctionInterfaceTrain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInterfaceTrain {
    public final int a = 6;
    public final int b = 8;

    public static <S, R> List<R> map(List<S> list, Function<S, R> f) {
        ArrayList<R> res = new ArrayList<>();
        list.forEach(a -> res.add(f.apply(a)));
        //list.forEach(System.out::println);
        return res;
    }

}
