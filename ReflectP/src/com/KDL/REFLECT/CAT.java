// -*- coding: utf-8 -*- 
/**
 * Project: ReflectP
 * Creator: yanking
 * Create time: 2021-11-11 17:37
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.KDL.REFLECT;

public class CAT {
    private String name = "招财喵";
    public int age = 10;
    public  String hobby = "唱歌";

    public CAT() {
    }

    public CAT(String name) {
        this.name = name;
    }

    public CAT(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public void hi(){
        System.out.println("My name is "+name);
    }
    public void cry(){
        System.out.println(name + "喵喵叫");
    }
}
