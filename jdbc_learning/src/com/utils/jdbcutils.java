// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-19 00:37
 * IDE: IntelliJ IDEA
 * Introduction:
 * 实现jdbc工具包
 * 包含mysql连接和退出功能
 */
package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcutils {
    private static String user = "";
    private static String url = "";
    private static String driver = "";
    private static String password = "";

    // 使用静态代码块初始化数据，并且连接数据库
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/mysql.properties"));
            driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            System.out.println(url);
            password = properties.getProperty("password");
            url = properties.getProperty("url");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    // 实现数据库的连接功能
    public static Connection conection()  {
        try {
            return  DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }

    //实现关闭功能
    public static void  shut(ResultSet resultset, Statement statement, Connection connection) {
        try {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }


}
