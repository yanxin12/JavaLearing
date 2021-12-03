// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-18 17:36
 * IDE: IntelliJ IDEA
 * Introduction:
 * jdbc入门
 * 连接数据库的五种方式，并且将实现sql语句
 */
package com.classnote.jdbc.myjdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class myjdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {


        /**
         * 连接mysql的第二种方式
         */

    }
    @Test
    public void conect_01() throws SQLException {
        //1. 注册驱动
        Driver driver = new Driver();
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/db01";

        //3.执行sql
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "k123");
        Connection connect = driver.connect(url, properties);
        Statement statement = connect.createStatement();
//        String sql = "insert  into person values(2,'小红')";
        String sql = "update person set name = '小白' where id = 2";
        int i = statement.executeUpdate(sql);
        System.out.println((i > 0) ? "成功" : "失败");
        //4.关闭连接资源
        statement.close();
        connect.close();
    }





    @Test
    public void conect_02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver o = (Driver) aClass.newInstance();
        String sql = "update person set name = '小白' where id = 2";
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/db01";

        //3.执行sql
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "k123");
        Connection connect1 = o.connect(url, properties);
        Statement statement1 = connect1.createStatement();
        int i1 = statement1.executeUpdate(sql);
        System.out.println(i1 > 0 ? "成功" : "失败");
        statement1.close();
        connect1.close();
    }

    @Test
public void connect_05() throws SQLException {
    //2. 获取连接
    String url = "jdbc:mysql://localhost:3306/db01";
    //3.执行sql
    Properties properties = new Properties();
    properties.setProperty("user", "root");
    properties.setProperty("password", "k123");
    Connection connection = DriverManager.getConnection(url, properties);
    Statement statement = connection.createStatement();
    System.out.println(connection);
}

}
