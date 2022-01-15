// -*- coding: utf-8 -*- 
/**
 * Project: EnumLearn
 * Creator: yanking
 * Create time: 2022-01-07 12:43
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.source;

public class main {
    // 创建一个枚举类，判断枚举常量是否是枚举类的一个实例
    enum Student {
        XIAOMING("小明", 12), XIAOZHAO("小赵", 13), XIAOHONG("小红", 14);
        String name;
        int age;

        Student(String name, int age) {
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
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
