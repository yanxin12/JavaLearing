// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-03 20:49
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxStudents_.LamdaLearn;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class ConsumerInterface {
    // 学习Java8 常用接口consumer
    public static void main(String[] args) {
        Consumer<String> consumer = x -> {
            System.out.println(x);
            System.out.println(x.split("!")[0] + " world!");
            System.out.println(x.split("!")[0] + " world   !");
        };
        consumer.accept("hello!");
    }


    @Test
    public void printInfo(String[] args) {
        String[] array = {"大雄，男", "静香，女", "胖虎，男"};

        printInfo(
                s -> System.out.print("姓名：" + s.split("，")[0] + "，"),
                s -> System.out.println("性别：" + s.split("，")[1] + "。"),
                array
        );
    }

    private void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            one.andThen(two).accept(info);
        }
    }


}
