// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-19 01:13
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcutils_use {
    public static void main(String[] args) {
    }

    @Test
    public void insert_() {
        Connection conection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into actor values(?,?)";
        try {
            //将connection 和 preparedStatement写在try里面为了捕捉可能存在的异常
            // 提高程序的健壮性能
            conection = jdbcutils.conection();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, 8);
            preparedStatement.setString(2, "周星馳");
            int i = preparedStatement.executeUpdate();
            System.out.println(i > 0 ? 1 : 0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcutils.shut(null, preparedStatement, conection);
    }

    @Test
    public void select_() {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from actor where name = ?";
        try {
            connection = jdbcutils.conection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "刘德华");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println(id + "\t" + name);
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            jdbcutils.shut(resultSet, preparedStatement, connection);
        }
    }

    @Test
    public void usetransaction() throws SQLException {
        Connection conection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update account set account = account-100 where id = 1";
        String sql2 = "update account set account = account+100 where id = 2";
        try {
            //将connection 和 preparedStatement写在try里面为了捕捉可能存在的异常
            // 提高程序的健壮性能
            conection = jdbcutils.conection();
            conection.setAutoCommit(false);
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.executeUpdate();
//            int i = 1 / 0;
            preparedStatement = conection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (Exception throwables) {
            System.out.println("出现异常！实现回滚！");
            conection.rollback();
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        } finally {
            conection.commit();
            jdbcutils.shut(null, preparedStatement, conection);

        }
    }

    @Test
    public void nobatch() {
        /**
         * 使用专车送5000次
         */
        Connection conection = null;
        PreparedStatement preparedStatement = null;
        try {
            //将connection 和 preparedStatement写在try里面为了捕捉可能存在的异常
            // 提高程序的健壮性能
            String sql = "insert into account values(?,?,?)";
            conection = jdbcutils.conection();
            preparedStatement = conection.prepareStatement(sql);
            System.out.println("开始执行！");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
//                preparedStatement.setString(1, null);
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "jack" + i);
                preparedStatement.setString(3, "500");
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("程序执行时间：" + (end - start));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcutils.shut(null, preparedStatement, conection);


    }


    @Test
    public void batch() {
        /**
         * 使用包车送5000次
         */
        Connection conection = null;
        PreparedStatement preparedStatement = null;
        try {
            //将connection 和 preparedStatement写在try里面为了捕捉可能存在的异常
            // 提高程序的健壮性能
            String sql = "insert into account values (?,?,?)";
            //实现批处理的时候需要addBatch、配置文件也需要写上?rewriteBatchedStatements = true
            //而且这里的values后面需要添加空格、处理完一批只有还需要实现Statement.clearBatch()
            conection = jdbcutils.conection();
            preparedStatement = conection.prepareStatement(sql);
            System.out.println("开始执行！");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000000; i++) {
//                preparedStatement.setString(1, null);
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "jack" + i);
                preparedStatement.setString(3, "500");
                preparedStatement.addBatch();
                if ((i + 1) % 1000 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("插入完毕！");
            System.out.println("程序执行时间：" + (end - start));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcutils.shut(null, preparedStatement, conection);


    }

    @Test
    public void c3p0_01() throws IOException, PropertyVetoException, SQLException {
        /**
         * c3p0的第一种使用方法
         * 在程序里面定义变量
         */
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(50);


        System.out.println("开始连接！");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("结束连接！总共耗时：" + (end - start));

    }

    @Test
    public void c3p0_02() throws SQLException {
        /**
         * 实现c3p0的第二种连接方式
         * 通过配置文件进行连接
         */
        ComboPooledDataSource yanking = new ComboPooledDataSource("yanking");
        System.out.println("开始连接！");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = yanking.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0第二种方法结束连接！总共耗时：" + (end - start));
    }





}
