package Innerclass;// -*- coding: utf-8 -*-

/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 16:28
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class main_ {
    public static void main(String[] args) {
        OuterClass.Innerclass innerclass = new OuterClass.Innerclass();
        innerclass.say();
        OuterClass.innerclass03 innerclass03 = new OuterClass().getinner03();
        innerclass03.say();
        new OuterClass.Innerclass() {
            @Override
            public void say() {
                System.out.println("hello !");
            }
        }.say();
    }


}
