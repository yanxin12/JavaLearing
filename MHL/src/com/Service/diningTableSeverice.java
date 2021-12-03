// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 13:06
 * IDE: IntelliJ IDEA
 * Introduction:
 * This is a service that use BAO  get the function
 */
package com.Service;

import com.DAO.DiningTableBAO;
import com.domain.diningTable;

import java.util.List;

public class diningTableSeverice {
    private DiningTableBAO diningTableBAO = new DiningTableBAO();

    public void showTableState() {
        //查看所有餐桌当前状态
        List<diningTable> tables = diningTableBAO.getMultiMessage(
                "SELECT id,state FROM diningTable", diningTable.class);
        System.out.println("序号\t\t桌子状态");
        for (diningTable table : tables) {
            System.out.println(table.getId() + "\t\t\t" + table.getState());
        }
    }

    //完成餐桌的预定
    // 需要对餐桌的状态进行判断
    public boolean judgeState(int id) {
        String state = (String) diningTableBAO.getSingleAttribute(
                "select state from diningTable where id = ?", id);
        if (state.equals("空")) {
            return true;
        }
        return false;
    }

    //实现餐桌预定功能
    public void bookTable(int id, String orderName, String orderTel) {
        diningTableBAO.Update("UPDATE diningTable SET state = '已经预定',\n" +
                "\tordername = ?,orderTel = ? WHERE id =?", orderName, orderTel, id);
    }

    //实现餐桌状态修改
    public boolean changeTableState(int diningTableID, String state) {
        int update = diningTableBAO.Update(
                "update diningTable set state = ? where id = ?", state, diningTableID);
        return update > 0;
    }

    public diningTable judgeExits(int id) {
        diningTable message = (diningTable) diningTableBAO.getSingleMessage(
                "select * from diningTable where  id = ?", diningTable.class, id);
        return message;
    }


    //实现结账完成之后表的初始化
    public boolean initTable(int diningTableID) {
        int update = diningTableBAO.Update(
                "update diningTable set state =?,orderName=?,orderTel=? where id=?",
                "空", "", "", diningTableID);
        return update > 0;
    }
}
