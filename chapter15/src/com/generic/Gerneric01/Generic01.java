// -*- coding: utf-8 -*- 
/**
 * Project: chapter15
 * Creator: yanking
 * Create time: 2021-10-26 15:13
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.generic.Gerneric01;

@SuppressWarnings({"all"})
public class Generic01 {
    static Integer a;
    static Integer b = 3;

    public static void main(String[] args) {
        Dog<String, Integer> dog = new Dog<String, Integer>("小黄",5);
//        System.out.println(dog.getName()+dog.getAge());
        String name = dog.getName();
//        name.show();
        Person<String> person01 = new Person<String>("小王");
        person01.f();
    }
}
class Dog<E,T>{
    private E name;
    private  T age;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public Dog(E name, T age) {
        this.name = name;
        this.age = age;

    }
}
class Person<E>{
    private E s;

    public Person(E s) {
        this.s = s;
    }

    public E getS() {
        return s;
    }

    public void setS(E s) {
        this.s = s;
    }
    public E f(){
        return s;
    }
}