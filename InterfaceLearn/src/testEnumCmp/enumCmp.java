// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-07 10:23
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package testEnumCmp;

import java.util.Comparator;

public class enumCmp {
    /*I want to construct a comparator by enum class*/
    enum cmp implements Comparator<Comparable<Object>> {
        INSTANCE;
        @Override
        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c1.compareTo(c2);
        }
    }
}
