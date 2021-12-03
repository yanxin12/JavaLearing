// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-26 23:40
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.Homework.homework01;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class homework01 {
    public static void main(String[] args) {
        news news01 = new news("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        news news02 = new news("男子突然想起两个月前钓的鱼还在网兜里，捞起来一看赶紧放生");
        ArrayList<news> news = new ArrayList<>();
        news.add(news01);
        news.add(news02);
//        System.out.println(news.size());
//        ArrayList<news> rev_news = new ArrayList<>();
//        for (int i = news.size()-1; i > 0 ; i++) {
//
//        }
//        遍历ArrayList
//        Iterator<src.Homework.homework01.news> iterator = news.iterator();
//        while (iterator.hasNext()) {
//            src.Homework.homework01.news next = iterator.next();
//            System.out.println(next);
//        }
//        System.out.println(news01.getTitle().length());
//        实现新闻标题的处理并且进行遍历
//        Iterator<src.Homework.homework01.news> iterator = news.iterator();
//        while (iterator.hasNext()) {
//            src.Homework.homework01.news next = iterator.next();
//            if(next.getTitle().length()>15){
//                    String title = next.getTitle().substring(0,15)+"...";
//                System.out.println(title);
//            }else{
//                System.out.println(next);
//            }
//        }
//        实现逆序输出处理过后的标题
        for (int i = news.size()-1; i >= 0; i--) {
            System.out.println(process(news.get(i).getTitle()));
        }
    }

    public static String process(String title) {
        if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        } else {
            return title;
        }
    }
}
