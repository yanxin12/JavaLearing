// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-18 20:17
 * IDE: IntelliJ IDEA
 * Introduction:
 * 程序使用Resultset 实现select对数据表的查询
 */
package com.classtrain.Resultset_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Resultset_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        String path = "src\\mysql.properties";
        String sql = "select * from actor";
        properties.load(new FileInputStream(path));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(id+"\t"+name);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
