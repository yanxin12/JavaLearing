// -*- coding: utf-8 -*- 
/**
 * Project: ReflectP
 * Creator: yanking
 * Create time: 2021-11-12 10:40
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.KDL.Homework.homework02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> filecls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = filecls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
//        Object o = filecls.newInstance();
        Constructor<?> constructor = filecls.getConstructor(String.class);
        Object o1 = constructor.newInstance("C:\\Users\\hp\\Desktop\\报名\\mynew.txt");
        Method createNewFile = filecls.getMethod("createNewFile");
        Object invoke = createNewFile.invoke(o1);
        System.out.println(invoke);

    }
}
