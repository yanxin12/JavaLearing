// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-03 18:31
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxStudents_.LamdaLearn;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class lambdaTrain {
    // Java lambda  表达式分为有返回值和没有返回值两种类型
    // 根据输入参数的实行又可以分为有输入和无输入两种类型
    @Test
    public void RunnableInterfaceTrain() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am Runnable Interface !");
            }
        };
        r.run();
    }

    @Test
    public void noInputLambdaTrain() {
        Runnable r = () -> System.out.println("I am noInput lambda!");
        r.run();
    }

    @Test
    public void InputLambdaTrain(){
        Consumer<String> res = (x) -> System.out.println(x);
    }


}
