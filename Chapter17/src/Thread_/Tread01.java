// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-10-29 10:53
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_;

public class Tread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
        System.out.println("主线程继续执行，主线程名称为" + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            try {
                Thread.sleep(1000);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


