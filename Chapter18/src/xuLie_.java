// -*- coding: utf-8 -*- 

import java.io.*;

/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-04 20:15
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class xuLie_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filepath = "C:\\Users\\hp\\Desktop\\报名\\data.dat";
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(filepath));
        oos.writeInt(100);

        oos.writeObject(new Dog("旺财", 3,"yellow","CHN"));
        oos.close();
        System.out.println("数据保存完成（序列化格式）！");

        //使用ObjectOutputStream实现反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
        System.out.println(ois.readInt());
        System.out.println(ois.readObject());
        if (ois!=null)
            ois.close();





    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private transient String color;
    private static String nation;

    public Dog(String name, int age, String color,String nation) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }
}