// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-19 20:06
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DAO.domain;

public class Student {
    private Integer id;
    private String name;
    private  Integer age;
    private  Integer classid;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer classid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classid = classid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classid=" + classid +
                '}';
    }
}
