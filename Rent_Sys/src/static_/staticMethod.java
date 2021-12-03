// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-05 10:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package static_;

public class staticMethod {

    static {
//        System.out.println("This is CodeBlock!");
//        inner inner = new inner(){
//            public void m1(){
//                System.out.println("This is my anonymous class!");
//            }
//        }.m1();


        inner inner = new inner();
        inner.m1();

    }

    static void print() {
        System.out.println("This is the static method!");
    }

    public static class inner {
        public void m1() {
            System.out.println("This is my inner class method!");
        }

    }
}
