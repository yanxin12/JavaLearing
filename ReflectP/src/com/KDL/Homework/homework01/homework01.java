// -*- coding: utf-8 -*- 
/**
 * Project: ReflectP
 * Creator: yanking
 * Create time: 2021-11-12 10:30
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.KDL.Homework.homework01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> Testcls = Class.forName("com.KDL.Homework.homework01.PrivateTest");
//        Object o = Testcls.newInstance();
        Constructor<?> constructor = Testcls.getConstructor();
        Object o = constructor.newInstance();
        Field name = Testcls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"小黄");
        Method getName = Testcls.getDeclaredMethod("getName");
        System.out.println(getName.invoke(o));

    }
}
