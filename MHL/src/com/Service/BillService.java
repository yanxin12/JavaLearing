// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 16:43
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Service;

import com.DAO.billDAO;
import com.domain.bill;

import java.util.List;
import java.util.UUID;

/**
 * 1. 改变餐桌状态
 * 2. 点餐需要创建订单
 * 2.1  菜品分开结账
 * 2.2 计算价格
 * 2.3 确认订单操作
 * 3. 取消点菜操作
 * 3.1 -1退出
 * 3.2 选完菜品之后确认
 */
public class BillService {
    private billDAO billDAO = new billDAO();

    // 点菜并且创建订单

    /**
     * @param menuid 点菜的id
     * @param nums   菜的份数
     */
    public void getBill(int menuid, int nums, int diningTableID) {
        //创建账单并且打印
        UUID uuid = UUID.randomUUID();

        //创建订单
        billDAO.Update("insert into bill values ( null,?,?,?,?,?,now(),?)", uuid.toString(), menuid, nums,
                (new MenuService().getSingleMenu(menuid).getPrice()) * nums, diningTableID, "未结账");
        //修改餐桌状态为“正在就餐”
        new diningTableSeverice().changeTableState(diningTableID, "正在就餐");
    }

    //实现查看账单（所有）
    public void listBill() {
        List<bill> message = billDAO.getMultiMessage("select * from bill", bill.class);
        System.out.println("编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t状态");
        for (bill bill : message) {
            System.out.println(bill);
        }
    }

    //实现结账功能

    /**
     * 1. 需要修改餐桌状态，即结账完成之后需要将餐桌状态初始化
     * 2. 修改账单信息，需要选择支付方法（state），将未支付更新为已支付
     * 3. 需要确认能够进行结账
     * 3.1 餐桌序号是否合理
     * 3.2  是否存在账单
     * 3.3 账单是否已结账
     * 4.  实现：
     * a. 方法实现
     */
    public boolean payBill(int diningTableID, String state) {
        // 1.  修改bill表，修改表之前需要判断是否符合修改条件，即有无结账
        if (!(billDAO.Update(
                "update bill set state = ? where diningTableID = ? and state = ?",
                state, diningTableID,"未结账") > 0)) {
            System.out.println("该餐桌并未存在未结账的账单！");
            return false;
        }
        // 2.  修改diningTable表
        if (!(new diningTableSeverice().initTable(diningTableID))) {
            return false;
        }
        return true;
    }
}
