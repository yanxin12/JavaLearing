// -*- coding: utf-8 -*- 
/**
 * Project: jdbc_learning
 * Creator: yanking
 * Create time: 2021-11-20 01:08
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DAO.Test;
import com.DAO.DAO.GoodsDAO;
import com.DAO.DAO.StudentDAO;
import com.DAO.domain.Goods;
import com.DAO.domain.Student;

import java.util.List;

public class test {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        // insert
//        studentDAO.Update("insert into student values (?,?,?,?)",
//                1,"小明",20,101);
        // select multiMessage
//        List<Student> multiMessage = studentDAO.getMultiMessage("select * from student where classid = ?", Student.class, 101);
//        for (Student student : multiMessage) {
//            System.out.println(student);
//        }

        // select Attribute
//        Object select_name_from_student_ = studentDAO.getSingleAttribute("select name from student where id = 8102");
//        System.out.println(select_name_from_student_);

//        Object sm = studentDAO.getSingleMessage("select * from student where name = ?", Student.class, "小明");
//        System.out.println(sm);
        GoodsDAO goodsDAO = new GoodsDAO();
        List<Goods> multiMessage = goodsDAO.getMultiMessage("select * from goods", Goods.class);
        for (Goods goods : multiMessage) {
            System.out.println(goods);
        }

    }
}
