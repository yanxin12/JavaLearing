// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 23:20
 * IDE: IntelliJ IDEA
 * Introduction:
 * 实现多表查询
 * 关键在于sql语句
 */
package com.Service;

import com.DAO.MultiPlayDAO;
import com.domain.MultiPlay;

import java.util.List;

public class MultiPlayService {
    private MultiPlayDAO multiPlayDAO = new MultiPlayDAO();

    //多表查询
    public void MulTabQuery(){
        List<MultiPlay> message = multiPlayDAO.getMultiMessage(
                "select bill.*,name,price from bill,menu where bill.menuid = menu.id", MultiPlay.class);
        System.out.println("编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t状态\t\t菜名\t\t价钱");
        for (MultiPlay multiPlay : message) {
            System.out.println(multiPlay);
        }
    }

}
