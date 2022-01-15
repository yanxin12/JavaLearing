// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-11 10:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.referenceFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


enum color {
    // 枚举类中的枚举变量类似一个实例化对象
    //YELLOW("黄色"), RED("红色"), BLUE("蓝色"), GREEN("绿色");
    YELLOW("Yellow"), RED("Red"), BLUE("Blue"), GREEN("Green");
    private String color;

    color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

public class Apple {
    private String name;
    private color color;
    // private float weight;
    private float weight;

    public Apple() {
    }

    public Apple(String name) {
        this.name = name;
    }

    public Apple(float weight) {
        this.weight = weight;
    }

    public Apple(String name, color color, float weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> p) {
        ArrayList<Apple> res = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                res.add(apple);
            }
        }

        return res;
    }

    public static List<Apple> filterAppleT(
            List<Apple> inventory, Predicate<Apple> p, Predicate<Apple> q) {
        ArrayList<Apple> res = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.and(q).test(apple)) {
                res.add(apple);
            }
        }
        return res;
    }

    public static boolean isGreenApple(Apple apple) {
        return "Green".equals(apple.getColor());
    }

    public static boolean isBigApple(Apple apple) {
        return apple.weight >= 10;
    }

    public static boolean isBigAndGreen(Apple apple) {
        return apple.color.equals("Green") && apple.weight >= 10;
    }

    public static void printPrettyApple(List<Apple> inventory, appleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }

    // use the Consumer interface to realize the function of parameter the behavior
    public static void printPrettyAppleT(List<Apple> inventory, Consumer<Apple> consumer) {
        for (Apple apple : inventory) {
            consumer.accept(apple);
        }

    }

    // Abstract the List Type beyond the problem domain
    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        ArrayList<T> res = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                res.add(t);
            }
        }
        return res;
    }


    // 快速实例化方法->单个参数
    public static <S, T> List<S> map(List<T> list, Function<T, S> f) {
        List<S> res = new ArrayList<>();
        for (T t : list) {
            res.add(f.apply(t));
        }
        return res;
    }

    // Use the Method Reference to Quickly Construct plenty of instance of three references
    public static <S, U, T, D> List<D> mapT(S[] name, U[] color, T[] weights, TriFunction<S, U, T, D> tf) {
        ArrayList<D> res = new ArrayList<>();
        int len = name.length;
        for (int i = 0; i < len; i++) {
            res.add(tf.apply(name[i], color[i], weights[i]));
        }
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public color getColor() {
        return color;
    }

    public void setColor(color color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    // Construct a three reference interface inorder to construct instance
    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }


    // parameterizing the behavior of print apple
    public interface appleFormatter {
        String accept(Apple a);
    }


//    public interface Predicate<T> {
//        boolean test(T t);
//    }
// 使用Java实现数学方法
public static double integrate(Function<Double, Double> f, double a, double b) {
    return (f.apply(a) + f.apply(b)) * (b - a) / 2;
}
}
