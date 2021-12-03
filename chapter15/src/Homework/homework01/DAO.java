// -*- coding: utf-8 -*- 
/**
 * Project: chapter15
 * Creator: yanking
 * Create time: 2021-10-28 17:03
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

import org.junit.jupiter.api.Test;

import java.util.*;

public class DAO<T> {
    private Map<String,T> map = new HashMap<>();


    public void save(String id,T entity){
        map.put(id, entity);
        System.out.println("Input Scuessful");
    }
    public  T get (String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id, entity);
    }


    @Test
//    实现返回指定泛型数据
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
//            if (map.get(next).getClass().equals(T)){
                list.add(get(next));
//            }
        }
        return list;

    }
    public void delete(String id){
        map.remove(id);
        System.out.println("Remove Scuessful !");
    }


}
