// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 10:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework02;

public class main_ {
    public static void main(String[] args) {
        Professor professor = new Professor("小王",58,"教授",15000);
        assistant_professor assistant_professor = new assistant_professor("小李",38,"副教授",5000);
        lector lector = new lector("小王", 18, "教授", 5000);
        professor.introduce();
        assistant_professor.introduce();
        lector.introduce();



    }
}
