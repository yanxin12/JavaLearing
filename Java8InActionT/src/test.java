// -*- coding: utf-8 -*- 

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiPredicate;

/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-14 15:09
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class test {
    public static int portNumber = 2032;
    public int tmp = 1234;
    BiPredicate<List<String>, String> contains = List::contains;

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    @Test
    public void shout() {
        int a = 8;
        Runnable r = () -> {
            System.out.println(a);
        };
        r.run();
    }

    @Test
    public void shout01() {
        System.out.println("Before" + portNumber);
        Runnable r = () -> this.setPortNumber(123);
        r.run();
        // Runnable r = () -> portNumber = 566; Lambda表达式的不能修改参数的值，只允许进行访问
        System.out.println("After" + portNumber);

    }

    @Test
    public void shout02() {
        People xiaoMing = new People("小明", 18);
        Runnable r = () -> {
            //System.out.println(xiaoMing.age);
            // xiaoMing.setAge(20);
            xiaoMing.age = 20;
            System.out.println(xiaoMing.age);
        };
        r.run();
    }

    @Test
    public void shout03() {
        Runnable r = () -> {
            portNumber = 3306;
            System.out.println(portNumber);
        };
        r.run();
    }

    @Test
    public void shout04() {
        int tmp = 1111;
        Runnable r = () -> {
            System.out.println(tmp);
        };
        r.run();
    }

    @Test
    public void shout05() {
        int tmp = 1111;
        Runnable r = () -> {

        };
        r.run();
    }

    @Test
    public void shout06() {
        // 使用方法引用实例化对象
//        Supplier<People> people = People::new;
//        System.out.println(people.get());
        // long startTime = System.nanoTime();
        //System.out.println("Hello!");
        //ong endTime = System.nanoTime();
        //  System.out.println(endTime - startTime);

        
    }


}

class People {
    String name = "小明";
    int age = 18;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
