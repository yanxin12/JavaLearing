// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-19 19:13
 * IDE: IntelliJ IDEA
 * Introduction:
 * 从数据库中获取resultSet数据，存储到POJO中
 */
package com.classtrain.JDBCUtilsByDruid_USE;

import com.utils.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCUtilsByDruid_USE {
    public static void main(String[] args) throws Exception {
        JDBCUtilsByDruid_USE jdbcUtilsByDruid_use = new JDBCUtilsByDruid_USE();
        jdbcUtilsByDruid_use.dbToList();
    }

    @Test
    public ArrayList dbToList() throws Exception {
        ArrayList<Actor> actor = new ArrayList<>();
        String sql = "select * from actor";
        Connection connection = JDBCUtilsByDruid.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            actor.add(new Actor(id, name));
        }
        JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        System.out.println("数据接收完毕！");
        for (Actor value : actor) {
            System.out.println(value);
        }
        return actor;
    }

    @Test
    public void shout(){
        System.out.println("aaaaa");
    }

}

