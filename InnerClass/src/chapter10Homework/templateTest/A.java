// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-11 14:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.templateTest;

public class A implements Job{
    String str = "";
    @Override
    public void job() {
        for (int i = 0; i < 8000; i++) {
            str += "Hello";
        }
    }
}
