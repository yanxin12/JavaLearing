// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 18:54
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework03;

public class Cellphone implements Cal{

    @Override
    public void work() {
        System.out.println("调用计算接口的work方法！");
    }

    public void testWork(){
        new Cellphone(){
            public void work() {
                System.out.println("我在调用计算接口的work方法！");
            }
        }.work();

    }
}
