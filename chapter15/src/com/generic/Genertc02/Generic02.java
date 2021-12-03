// -*- coding: utf-8 -*- 
/**
 * Project: chapter15
 * Creator: yanking
 * Create time: 2021-10-26 15:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.generic.Genertc02;


import java.util.*;

@SuppressWarnings({"all"})
public class Generic02 {
    public static void main(String[] args) {
        Student s1 = new Student("小王",18);
        Student s2 = new Student("小李",20);
        Student s3 = new Student("小宋",22);
        HashSet<Student> stu_set = new HashSet<>();
        HashMap<String, Student> stu_map = new HashMap<String, Student>();
        stu_set.add(s1);
        stu_set.add(s2);
        stu_set.add(s3);
        stu_map.put(s1.getName(), s1);
        stu_map.put(s2.getName(), s2);
        stu_map.put(s3.getName(), s3);
//        1.使用增强for进行遍历
//        for (Student student :stu_set) {
//            System.out.print(student.toString());
//        }
//        遍历set_map
//        Set<String> keySet = stu_map.keySet();
//        for (String s_name :keySet) {
//            System.out.println(stu_map.get(s_name).toString());
//        }


//        2.使用迭代器进行遍历
//        Iterator<Student> iterator01 = stu_set.iterator();
//        while (iterator01.hasNext()) {
//            Student stu01 =  iterator01.next();
//            System.out.print(stu01);
//        }
//        使用迭代器遍历set_map
//        Set<String> keySet = stu_map.keySet();
//        Iterator<String> s_name = keySet.iterator();
//        while (s_name.hasNext()) {
//            String key =  s_name.next();
//            System.out.print(stu_map.get(key));
//        }
//使用迭代器遍历stu_map
        Set<Map.Entry<String, Student>> entries = stu_map.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.print(next.getKey()+"-"+next.getValue());
        }

    }
}




class Student{
    private String name;
    private int age;

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
        return  this.getName()+"今年"+this.getAge()+"岁了，还是个学生\n";
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;



    }
}