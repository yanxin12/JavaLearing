package com.learning;

import com.learning.myJava.studyGroup.Pupil;

public class li extends Pupil {
    public static void main(String[] args) {
        Pupil li = new Pupil();
        li.setSalary(5000);
        double sal = li.getSalary();
        li.setAge(11);
        int age = li.getAge();
        li.setName("LiMing");
        String name = li.getName();
        li.setScores(96);
        double scores = li.getScores();
        System.out.println("name = " + name +
                "age = " + li.age + "scores = " + scores +
                "salrary = " + sal);


    }
}
