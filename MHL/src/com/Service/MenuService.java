// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 16:09
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Service;

import com.DAO.menuDAO;
import com.domain.menu;

import java.util.List;


public class MenuService {
    private menuDAO menuDAO = new menuDAO();

    // 实现展示所有菜品
    public void showMenu() {
        List<menu> message = menuDAO.getMultiMessage("select * from menu", menu.class);
        System.out.println("序号\t\t菜名\t\t类别\t\t价格");
        for (menu menu : message) {
            System.out.println(menu);
        }
    }

    // 根据id展示菜品
    public menu getSingleMenu(int id) {
        menu message = (menu) menuDAO.getSingleMessage(
                "select * from menu where id = ?", menu.class, id);


        return message;
    }




}
