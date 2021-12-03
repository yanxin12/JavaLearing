// -*- coding: utf-8 -*- 
/**
 * Project: Collection
 * Creator: yanking
 * Create time: 2021-08-17 20:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class set_ {
    public static void main(String[] args) {


//        HashSet set = new HashSet();
//        set.add("hello!");
//        set.add("hello!");
//        set.add("hello!");
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//
//        }
        HashMap<String, String> map = new HashMap<>();
        map.put("hsp","hsp的老婆");
        map.put("ss","ss的老婆");
        Set<String> ketset = map.keySet();
        Iterator<String> Iterator = ketset.iterator();
        while (Iterator.hasNext()) {
            String next =  Iterator.next();
            
        }
        


        System.out.println(map);



    }

}
