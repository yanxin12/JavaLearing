// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-15 13:13
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.referenceFunc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceConstructMul {

    // 当类中存在多参数构造器的时候，使用方法引用快速实例化大量对象
    @Test
    public void shout() {
        // float[] a = {1.2f, 2.88f, 3.56f, 4.93f, 5.88f, 6.88f};
        //System.out.println(a.getClass());
        List<Float> floats = Arrays.asList(2.33f, 0.56f, 4.24f);
        List<Apple> res = Apple.map(floats, Apple::new);
        for (Apple apple : res) {
            System.out.println(apple);
        }


    }

    @Test
    public void shout02() {

        // Construct multiInstances
        String[] name = {"RedApple", "YellowApple", "BlueApple"};
        // String[] Color = {"RED", "YELLOW", "BLUE"};
        // String[] Color = {color.YELLOW.getColor(),c};
        color[] colors = {color.YELLOW, color.BLUE, color.RED};
        Float[] weight = {8.8f, 6.6f, 9.9f};
        List<Apple> res = Apple.mapT(name, colors, weight, Apple::new);
        for (Apple apple : res) {
            System.out.println(apple);
        }


    }

    @Test
    public void shout03() {
        // to construct a complicate function
        Function<String, Integer> f1 = Integer::parseInt;
        Function<Integer, Double> f2 = Math::log;
        Double res = f2.compose(f1).apply("100");
        System.out.println(res);
    }

    @Test
    public void shout04() {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transFormationPipeLine =
                addHeader.andThen(Letter::checkText).andThen(Letter::addTailer);
        String res = Letter.connect("I am Jack,labda ", transFormationPipeLine);
        System.out.println(res);
    }

    @Test
    public void shout05() {
        double res = Apple.integrate((Double a) -> a + 10, 3, 7);
        System.out.println(res);
    }

    @Test
    public void shout06() {
        Function<String, Apple> createApple = Apple::new;
        Apple redApple = createApple.apply("RedApple");
        System.out.println(redApple);

    }
}
