// -*- coding: utf-8 -*- 
/**
 * Project: ReflectP
 * Creator: yanking
 * Create time: 2021-11-11 17:34
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.KDL.REFLECT;

import org.junit.jupiter.api.Test;

import javax.jws.WebMethod;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Properties;

public class reflect_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //通过反射机制实现对CAT类中的hi方法和cry方法进行调用
        /**
         * 通过输入流读取properties中的类路径和相关方法
         * 使用反射机制实现方法
         */
        //1.通过输入流获取类路径
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\KDL\\REFLECT\\rp_properties"));
        String classfullPath = properties.getProperty("classfullPath");
        String method = properties.getProperty("method");
        //System.out.println(classfullPath);
        //System.out.println(method);
        //2.使用反射方法实现方法调用
        //获取类的路径
        Class cls = Class.forName(classfullPath);
        //创建实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        Method method1 = cls.getMethod(method);
        System.out.println("=========================");
//        method1.invoke(o);
        Field age = cls.getField("age");
//        System.out.println(age.get(o));
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
        System.out.println(cls.getClass());
        System.out.println(cls);
        System.out.println(cls.getPackage());
        System.out.println(cls.getPackage().getName());
        method1.setAccessible(true);
        System.out.println(cls.getName());
        Object o1 = cls.getConstructor().newInstance();
//        System.out.println(o1.getClass());
        method1.invoke(o1);
        age.set(o, 2);
        System.out.println(age.get(o));
        System.out.println(age.get(o1));
        Field[] fields = cls.getFields();//获取所有字段属性
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println(CAT.class.getName());
        CAT cat = new CAT();
        System.out.println(cat.getClass().getName());
        Class<? extends CAT> clst = cat.getClass();
        Field age1 = clst.getField("age");
//        System.out.println(age1.get(clst));
        System.out.println(age1.get(o));
        System.out.println(cls.getConstructor(String.class).toString());
        System.out.println(cls.getConstructor(String.class));
        System.out.println(cls.getConstructor());
//        System.out.println(cls.getConstructor(String.class,int.class,String.class,String.class));   NoSuchMethodException
        System.out.println(cls.getConstructor(String.class,int.class,String.class));
        //通过类加载器得到类对象
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> cls02 = classLoader.loadClass("com.KDL.REFLECT.CAT");
        System.out.println(cls02);
//        System.out.println(age.get(cls02));
        Class<Integer> integerClass = int.class;
        Class<String> stringClass = String.class;
        System.out.println(integerClass);
        //包装类.TYPE
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);
        System.out.println(Integer.class.hashCode());
        System.out.println(Class.forName("java.lang.Integer").hashCode());
        Integer integer = new Integer(2);
        System.out.println(integer.getClass().hashCode());
        System.out.println(int.class.hashCode());
        System.out.println(Integer.TYPE.hashCode());
        Class<Class> cls04 = Class.class;



    }
}
