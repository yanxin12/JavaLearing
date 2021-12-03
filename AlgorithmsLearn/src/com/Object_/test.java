// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-24 16:14
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Object_;

import java.util.Iterator;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        // 栈的实现
        Stack<String> brackets = new Stack<>();
        String push = brackets.push("(");
//        System.out.println(push);
//        System.out.println(brackets.peek());
        Iterator<String> iterator = brackets.iterator();
        while (iterator.hasNext()) {
            String next =  iterator.next();

        }

//        StringStack stringStack = new StringStack();
    }

    public static void setNull(Person person) {
        person.setAge(15);
        person.setName("小红");
        person = null;
    }
}
