// -*- coding: utf-8 -*- 
/**
 * Project: chapter15
 * Creator: yanking
 * Create time: 2021-10-28 17:36
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

public class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        super();
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
