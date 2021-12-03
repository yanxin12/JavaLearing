// -*- coding: utf-8 -*- 
/**
 * Project: ReflectP
 * Creator: yanking
 * Create time: 2021-11-12 01:16
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.KDL.REFLECT;

/**
 * 判断程序在初始换的时候子类和父类初始化的顺序
 * 结论：
 *          初始换顺序：
 *              1.创建对象 new subobject()
 *                  父类代码块（从上往下）->子类代码块（从上往下）->父类构造器->子类构造器
 *                  创建对象的时候调用构造器，所有构造器(子类和父类)会运行
 *              2. 直接使用类中的静态方法
 *                  父类代码块（从上往下）->子类代码块（从上往下）->静态方法
 */

public class Test_ {
    public static void main(String[] args) {
        B.smile();
//        B b = new B();
    }
}

class  A {
    public A() {
        System.out.println("I am A constructure!");
    }

    private static void shout(){
        System.out.println("I am shoutting!");
    }
    static {
        System.out.println("I am A!");
        b =2;
    }
    private static int b;
    public static void smile(){
        System.out.println("I am smiling!");
    }
    static {
        System.out.println("I am A2");
        System.out.println(b);
    }
}
class B extends A{
    public B() {
        System.out.println("I am B constructure!");
    }
    private static void shout(){
        System.out.println("B :I am shoutting!");
    }
    static {
        System.out.println("I am B!");
        b =6;
    }
    private static int b;
    public static void smile(){
        System.out.println("B:I am smiling!");
    }
    static {
        System.out.println("I am B2");
        System.out.println(b);
    }
}