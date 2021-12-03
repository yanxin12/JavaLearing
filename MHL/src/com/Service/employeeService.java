// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 15:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Service;

import com.DAO.employeeDAO;
import com.domain.employee;

import java.util.List;

public class employeeService {
    private employeeDAO employeeDAO = new employeeDAO();


    /**
     * 使用分表登陆
     * public boolean login(String empid, String pwd) {
     * employee message = (employee) employeeDAO.getSingleMessage(
     * "select * from employee where pwd = MD5(?) and empid = ?",
     * employee.class, pwd, empid);
     * if (message == null) {
     * return false;
     * } else {
     * System.out.println("成功登陆！");
     * return true;
     * }
     * }
     */

    /**
     * 实现人事管理
     * 方法：
     *      1. 打印所有人信息
     *      2. 打印指定人信息
     *      3. 增加职工人数
     *      4. 删除职工人数
     *      5. 修改职工信息
     */

    // 实现获取职员信息方法
    public void listStaff() {
        List<employee> message = employeeDAO.getMultiMessage(
                "select * from employee", employee.class);
        for (employee employee : message) {
            System.out.println(employee);
        }
    }

    //获取指定职员信息方法
    public void listPointStaff(String empid) {
        employee message = employeeDAO.getSingleMessage(
                "select * from employee where empid = ?", employee.class, empid);
        System.out.println(message);

    }

    //增加职工人数pu
    //传入一对数据，使用insert
    public boolean addStaff(){
        return false;
    }
    //删除职工数据
    //获取empid，delete from where empid=?
    public boolean minusStaff(){
        return false;
    }
    //更改职工数据
    //获取需要更改的数据，使用update语句即可




}
