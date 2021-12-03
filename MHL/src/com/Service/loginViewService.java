// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-21 00:05
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Service;

import com.DAO.loginViewDAO;
import com.domain.employee;
import com.domain.loginView;

public class loginViewService {
    private loginViewDAO loginViewDAO = new loginViewDAO();
    //验证登陆信息
    public boolean login(String empid, String pwd) {
        loginView message = loginViewDAO.getSingleMessage(
                "select * from loginView where empid = ? and pwd = MD5(?)",
                loginView.class,empid,pwd);
        if (message == null) {
            return false;
        } else {
            System.out.println("成功登陆！");
            return true;
        }
    }


}
