// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-25 23:37
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.list_.set_;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
//        TreeSet treeSet = new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return ((String) o1).compareTo((String) o2);
//            }
//        });
//        按照长度大小进行排序
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (((String)o1).length()<((String)o2).length())
                    return 1;
                else
                    return  -1;
//                 return ((String)o1).length() - ((String)o2).length();
            }
        });

//        String str1 = "abc";
//        String str2 = "hsp";
//        char v1[] = str1.toCharArray();
//        char v2[] = str2.toCharArray();
//        System.out.println(v1);
//        System.out.println(v2);
//        System.out.println(v1[2]);
        treeSet.add("abc");
        treeSet.add("bbc");
        treeSet.add("cbc");
        treeSet.add("ddddbc");
        treeSet.add("aabc");
        System.out.println(treeSet);





    }
}
