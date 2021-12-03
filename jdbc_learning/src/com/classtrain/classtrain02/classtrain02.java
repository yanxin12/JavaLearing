// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-18 22:35
 * IDE: IntelliJ IDEA
 * Introduction:
 * 课堂练习2
 * 使用preparedStatement 实现sql语句
 */
package com.classtrain.classtrain02;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class classtrain02 {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        String path = "src\\mysql.properties";
        properties.load(new FileInputStream(path));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
//        String sql = "insert into admin values(?,?)";
//        String sql = "update admin set name = ? where name = ? ";
//        String sql = "DELETE FROM admin WHERE NAME = ?";
        String sql = "select * from admin ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1,5);
//        preparedStatement.setString(1,"king");
//        preparedStatement.setString(2,"tbh");
//        int i = preparedStatement.executeUpdate();
//        System.out.println(i>0?"操作成功":"操作失败");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(id + "\t" + name);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();


    }
}
