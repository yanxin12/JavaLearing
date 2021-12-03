// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-19 23:42
 * IDE: IntelliJ IDEA
 * Introduction:
 * 编写公用DAO（data access Object）
 */
package com.DAO;


import com.Utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class BasicDAO<T> {
    // select多条语句
    // 这边泛型T的具体化可以是后续子类调用方法返回值的直接确定而不是Object类
    public List<T> getMultiMessage(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //select单条语句
    public T getSingleMessage(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    //DML语句
    public int Update(String sql, Object... params) {
        Connection connection = null;
        int update = 0;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            update = queryRunner.update(connection, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
            return update;
        }
    }

    //select 单个字段
    public Object getSingleAttribute(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            return queryRunner.query(connection, sql, new ScalarHandler<>(), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
