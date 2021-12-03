// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-06 20:56
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package innerClass;

public class outerClass {
    public static int a = 10;

    static {
        System.out.println("This is my static codeBlock !");
    }

    String c = "hello";
    private double b = 20;

    {
        System.out.println("This is my codeBlock!");
    }

    public static void m2() {
        System.out.println("This public method m2 !");
    }

    public void m1() {
        System.out.println("This public method m1 !");
    }

    public void m3() {
        int a = 99;
        class inner01 implements A {
            int a = 999;

            public void say() {
                System.out.println("This is my local innerClass's method say() !");
                System.out.println("a = " + a);
            }

            @Override
            public void m() {
                System.out.println("This is my interface method in the inner class!");
            }
        }
        System.out.println(new inner01().a);
       new inner01().say();
       new inner01().m();
//        inner01 inner02 = new inner01(){
//            @Override
//            public void say() {
//                System.out.println("This say() is my anonymous say()!");
//            };



        };
    }










