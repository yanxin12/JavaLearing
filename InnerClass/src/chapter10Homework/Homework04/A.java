// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 19:07
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework04;

public class A {
    String name = "大王";
    public void m1(){
        class B{
            final private String name = "小王";
            public void show(){
                System.out.println("name = " + name);
                System.out.println("name = " + A.this.name);
            }
        }
        B b = new B();
        b.show();
    }

}
