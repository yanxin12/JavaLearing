// -*- coding: utf-8 -*- 
/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-05 17:22
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework03;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class homework03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("F:\\Java_idea\\Chapter18\\src\\Homework\\homework03\\dog.properties"));
        // properties.list(System.out);
        //通过properties文件里面的数据实现对dog类的·初始化
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");
        System.out.println(name);
        System.out.println(age);
        System.out.println(color);
        Dog dog = new Dog(name, Integer.parseInt(age), color);
        System.out.println(dog);


    }
}
