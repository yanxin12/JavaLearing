// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-19 16:33
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.druid_;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.utils.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;


public class druid_ {
    /**
     * 实现druid连接
     * 并且测试连接速度
     */
    @Test
    public void useDruid_() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        String sql = "insert into account values (?,?,?)";
        System.out.println("开始连接！");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 8000000; i++) {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, i + 1);
            preparedStatement.setString(2,"jack"+i);
            preparedStatement.setInt(3,i*10);
            preparedStatement.addBatch();
            if ((i+1)%10000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
            connection.close();
        }
        long end = System.currentTimeMillis();

        System.out.println("c3p0第二种方法结束连接！总共耗时：" + (end - start));
    }



    @Test
    public void useDruid_02() throws Exception {
        String sql = "insert into account values (?,?,?)";
        Connection connection = JDBCUtilsByDruid.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始连接！");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 8000000; i++) {
            preparedStatement.setInt(1, i + 1);
            preparedStatement.setString(2,"jack"+i);
            preparedStatement.setInt(3,i*10);
            preparedStatement.addBatch();
            if ((i+1)%10000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        JDBCUtilsByDruid.close(null,preparedStatement,connection);
        System.out.println("c3p0第二种方法结束连接！总共耗时：" + (end - start));
    }

}
