package Innerclass;// -*- coding: utf-8 -*-

/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 16:05
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class OuterClass {
    public String name;

   static class Innerclass implements A {
        @Override
        public void say() {
            System.out.println("I am in the outerClass , I am InnerClass!");
        }
    }
    public void m1(){
       class  innerclass01 implements A{
           @Override
           public void say() {
               System.out.println("Local class, I am in method m1()!");
           }
       }

    }
    class innerclass03 implements A{
        @Override
        public void say() {
            System.out.println("I am a Local class without static!");
        }
    }
   public innerclass03 getinner03(){
       return new innerclass03();
   }
    
}