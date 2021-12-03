// -*- coding: utf-8 -*- 
/**
 * Project: Collection
 * Creator: yanking
 * Create time: 2021-09-08 19:09
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package ClassWork.ClassWork01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class main {
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put(1, new Staff("小明", "Student", 8000.0));
        map.put(2, new Staff("小王", "Teacher", 18000.0));
        map.put(3, new Staff("小李", "Worker", 28000.0));
//        Set keySet = map.keySet();
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            Staff staff = (Staff) next.getValue();
            if (staff.getSaraly() >= 18000) {
                System.out.println(staff);


            }

//        for (Object key : keySet){
//            Staff staff = (Staff) map.get(key);
//            if(staff.getSaraly()>=18000){
//                System.out.println(staff);
//            }
//        }
//        Iterator iterator = keySet.iterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            Staff staff = (Staff) map.get(next);
//            if (staff.getSaraly() >= 18000) {
//                System.out.println(staff);
//            }


        }
    }
}



