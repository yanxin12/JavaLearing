// -*- coding: utf-8 -*- 
/**
 * Project: Serialize_Learn
 * Creator: yanking
 * Create time: 2022-01-05 11:41
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.serializable_data;

import java.io.Serializable;

public class Student implements Serializable {
    // 显示声明serialVersionUID
    private static final long serialVersionUID = 2L;
    public String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
