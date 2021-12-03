// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-19 20:03
 * IDE: IntelliJ IDEA
 * Introduction:
 * 使用Apche的DBUtils实现数据获取
 */
package com.classtrain.ApDButils_;

import com.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class ApDButils_ {


    @Test
    public void getData() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from student";
        List<Student> query =
                queryRunner.query(connection, sql, new BeanListHandler<>(Student.class));
        for (Student student : query) {
            System.out.println(student);

        }
        JDBCUtilsByDruid.close(null, null, connection);
    }


    @Test
    /**
     * 使用DBUtil+Druid实现批量处理
     */
    public void noUseBatch() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "insert into account values (?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        int i = queryRunner.update(connection, sql, 1, "jack", 300);
        System.out.println(i > 0 ? "完成添加" : "无效添加");
        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    public void UseBatch() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "insert into account values (?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        //将参数封装成一个集合中
        Object[][] Param = new Object[50000][];
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 50000; i++) {
                Param[i] = new Object[3];
                Param[i][0] = (i+1)+j*50000;
                Param[i][1] = "jack" + i;
                Param[i][2] = i * 10;
            }
            queryRunner.batch(connection, sql, Param);
        }

        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));

        JDBCUtilsByDruid.close(null, null, connection);
    }


}
