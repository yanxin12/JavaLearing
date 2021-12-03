// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-05 10:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package InterFace;

import Abstract.Person;

public class Student extends Person implements A, action {
    String Stu_id;

    public Student(String name, String stu_id, int age) {
        Stu_id = stu_id;
        this.name = name;
        this.age = age;
    }

    @Override
    public void smile() {
        System.out.println("I am a Student, I can smile lightly!");
    }

    @Override
    public void jump() {
        System.out.println("I am a Student, I can jump lightly!");
    }

    @Override
    public void interest() {
        System.out.println("I am a Student, my interesting is playing basketball!");
    }

    public void show(){
        System.out.println(b);
    }
    public A getInterFace(A a){
        return a;
    }
}
