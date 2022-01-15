// -*- coding: utf-8 -*- 
/**
 * Project: Serialize_Learn
 * Creator: yanking
 * Create time: 2022-01-05 11:39
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.serializable_data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class serializable_data {

    // 实现序列化操作
    // 并且验证.ser文件
    public static void main(String[] args) {
        // 初始化类信息
        //Student xiaoHong = new Student("小红", 12);
        // 类信息序列化,将已有的类信息序列化并且通过Java对象流存储信息
/*        try {
            FileOutputStream fs = new FileOutputStream("stu.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            oos.writeObject(xiaoHong);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        // 读取序列化文件里面的实例信息，并且在控制台输出
        try {
            FileInputStream fis = new FileInputStream("stu.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(ois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
