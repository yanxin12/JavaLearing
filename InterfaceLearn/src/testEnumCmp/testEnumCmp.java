// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-07 10:22
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package testEnumCmp;

import java.util.Arrays;
import java.util.Comparator;

public class testEnumCmp {
    public static void main(String[] args) {
        Integer[] ints = {2, 3, 7, 6, 8, 34, 32, 5};
        Arrays.sort(ints, (Comparator) enumCmp.cmp.INSTANCE);
        for (Integer integer : ints) {
            System.out.println(integer);
        }

    }
}
