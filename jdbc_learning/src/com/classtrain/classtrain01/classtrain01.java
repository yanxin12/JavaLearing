// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-18 19:06
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.classtrain.classtrain01;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class classtrain01 {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        /**
         * 使用方式5连接数据库
         */
        // 1. 获取properties文件中的数据
        String path = "src\\mysql.properties";
//        String sql = "INSERT INTO actor VALUES(\n" +
//                "\tNULL,'刘德花')";
        String sql = "delete from actor where id = 2";
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
//        String password = "k123";
//        String url = "jdbc:mysql://localhost:3306/db01";
        String driver = properties.getProperty("driver");
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i > 0 ? "成功" : "失败");
        statement.close();
        connection.close();






    }
}
